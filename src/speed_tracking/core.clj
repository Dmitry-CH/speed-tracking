(ns speed-tracking.core
  (:require [ring.adapter.jetty :refer [run-jetty]]
            [speed-tracking.handler :refer [app-dev]]
            [speed-tracking.db.core :refer [connect-db disconnect-db]])
  (:gen-class))

(defonce server (atom nil))

(def server-opts {:port 8000
                  :join? false})

(defn start-server []
  (reset! server
          (run-jetty app-dev server-opts)))

(defn stop-server []
  (when-some [s @server]
    (.stop s)
    (reset! server nil)))

(defn -main [& args]
  (start-server)
  (connect-db))

(comment
  (start-server)
  (stop-server)
  (connect-db)
  (disconnect-db))
