(ns speed-tracking.core
  (:require [ring.adapter.jetty :refer [run-jetty]]
            [speed-tracking.handler :refer [app-dev]]
            [speed-tracking.db.core :refer [connect-db disconnect-db]])
  (:gen-class))

(defonce server (atom nil))

(defn start-server [& {:as opts}]
  (reset! server
          (run-jetty app-dev opts)))

(defn stop-server []
  (when-some [s @server]
    (.stop s)
    (reset! server nil)))

(defn -main [& [port]]
  (let [port (Integer. (or port (System/getenv "PORT") 5000))
        join? false]
    (start-server :port port
                  :join? join?)
    (connect-db)))

(comment
  (start-server :port 8000 :join? false)
  (stop-server)
  (connect-db)
  (disconnect-db))
