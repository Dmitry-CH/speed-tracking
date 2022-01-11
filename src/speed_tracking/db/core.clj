(ns speed-tracking.db.core
  (:require [monger.core :as mg]))

(defonce conn (atom nil))
(def ^:dynamic *db* nil)

(defn connect-db []
  (let [c (mg/connect)
        d (mg/get-db c "speedTracking")]
    (reset! conn c)
    (set! *db* d)))

(defn disconnect-db []
  (when-some [c @conn]
    (mg/disconnect c)
    (reset! conn nil)
    (set! *db* nil)))
