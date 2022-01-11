(ns speed-tracking.handler
  (:require [compojure.core :refer [defroutes]]
            [compojure.route :as route]
            [ring.middleware.json :refer [wrap-json-response]]
            [ring.middleware.reload :refer [wrap-reload]]
            [speed-tracking.api.v1.core :refer [get-brands-router get-brands-id-router]]))

(defroutes main-routes
  get-brands-router
  get-brands-id-router
  (route/not-found "Route not found"))

(defn- wrap-common [handler]
  (-> handler
      wrap-json-response))

(def app-dev (-> #'main-routes
                 wrap-reload
                 wrap-common))

(def app (-> main-routes
             wrap-common))
