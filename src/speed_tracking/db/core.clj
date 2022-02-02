(ns speed-tracking.db.core
  (:require [environ.core :as environ]
            [monger.core :as mg]
            [monger.collection :as mc]))

(defonce conn (atom nil))
(defonce db (atom nil))

(defn connect-db []
  (let [uri (or (environ/env :mongodb-uri) (System/getenv "MONGODB_URI"))
        {conn* :conn db* :db} (mg/connect-via-uri uri)]
    (reset! conn conn*)
    (reset! db db*)))

(defn disconnect-db []
  (when-some [conn* @conn]
    (mg/disconnect conn*)
    (reset! conn nil)
    (reset! db nil)))

(defn get-brand-by-id [id]
  (let [d (mc/find-one-as-map @db "brands" {:name id})]
    (update d :_id str)))
