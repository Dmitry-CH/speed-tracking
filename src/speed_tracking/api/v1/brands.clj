(ns speed-tracking.api.v1.brands
  (:require [clojure.string :as str]
            [compojure.core :refer :all]))

(def get-brands-router
  (GET "/api/v1/brands" [] "All brands"))

(def get-brands-id-router
  (GET "/api/v1/brands/:id" [id]
    (str "The brands ID is " (str/upper-case id))))
