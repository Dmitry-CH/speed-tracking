(ns speed-tracking.core
  (:require [ring.adapter.jetty :refer [run-jetty]]
            [speed-tracking.handler :refer [app*]])
  (:gen-class))

(defonce server (atom nil))

(def server-opts {:port 8000
                  :join? false})

(defn start-server []
  (reset! server
          (run-jetty app* server-opts)))

(defn stop-server []
  (when-some [s @server]
    (.stop s)
    (reset! server nil)))

(comment
  (start-server)
  (stop-server))
