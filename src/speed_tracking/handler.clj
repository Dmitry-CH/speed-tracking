(ns speed-tracking.handler
  (:require [compojure.core :refer [defroutes ANY]]
            [compojure.route :as route]
            [ring.middleware.json :refer [wrap-json-response]]
            [ring.middleware.keyword-params :refer [wrap-keyword-params]]
            [ring.middleware.params :refer [wrap-params]]
            [ring.middleware.reload :refer [wrap-reload]]
            [speed-tracking.api.v1.core :refer [get-brands-router get-brands-id-router]]))

(defroutes app-handler
  get-brands-router
  get-brands-id-router
  (ANY "/health" _ "ok")
  (route/not-found "Route not found"))

(def ^:private wrap-params+ (comp
            wrap-params
            wrap-keyword-params))

(defn- wrap-common [handler]
  (-> handler
      wrap-json-response
      wrap-params+))

(def app-dev (-> #'app-handler
                 wrap-reload
                 wrap-common))

(def app (-> app-handler
             wrap-common))
