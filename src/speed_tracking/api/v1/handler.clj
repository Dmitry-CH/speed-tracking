(ns speed-tracking.api.v1.handler
  (:require [ring.util.response :refer [response]]
            [speed-tracking.db.core :refer :all]))

(defn handle-a []
  (response {:data {:foo "all1"}}))

(defn handle-b [id]
  (response (get-brand-by-id id)))
