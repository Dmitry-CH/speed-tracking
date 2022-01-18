(ns speed-tracking.api.v1.core
  (:require [compojure.core :refer :all]
            [speed-tracking.api.v1.handler :refer :all]))

(def get-brands-router
  (GET "/api/v1/brands" []
    (handle-a)))

(def get-brands-id-router
  (GET "/api/v1/brands/:id" [id]
    (handle-b id)))
