(ns speed-tracking.db.core
  (:require [environ.core :as environ]
            [monger.core :as mg]
            [monger.collection :as mc]))

(defonce conn (atom nil))
(defonce db (atom nil))

(defn connect-db []
  (let [c (mg/connect)
        d (mg/get-db c "speedTracking")
        env (environ/env :db-url)]
    (reset! conn c)
    (reset! db d)))

(defn disconnect-db []
  (when-some [c @conn]
    (mg/disconnect c)
    (reset! conn nil)
    (reset! db nil)))

(defn get-brand-by-id [id]
  (let [d (mc/find-one-as-map @db "brands" {:name id})]
    (update d :_id str)))
