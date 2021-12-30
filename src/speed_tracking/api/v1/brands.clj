(ns speed-tracking.api.v1.brands
  (:require [compojure.core :refer :all]
            [ring.util.response :refer [response]]))

(def get-brands-router
  (GET "/api/v1/brands" []
    (response {:foo "all"})))

(def get-brands-id-router
  (GET "/api/v1/brands/:id" [id]
    (response {:foo id})))
