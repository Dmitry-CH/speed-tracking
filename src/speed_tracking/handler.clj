(ns speed-tracking.handler
  (:require [compojure.core :refer [defroutes]]
            [compojure.route :as route]
            [ring.middleware.reload :refer [wrap-reload]]
            [speed-tracking.api.v1.brands :refer [get-brands-router get-brands-id-router]]))

(defroutes main-routes
  get-brands-router
  get-brands-id-router
  (route/not-found "Route not found"))

(def app-dev (-> #'main-routes
             wrap-reload))

(def app (-> main-routes
             identity))
