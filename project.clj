(defproject speed-tracking "0.1.0-SNAPSHOT"
  :description "Websites loading speed tracking app"
  :url "https://gitlab.kodixauto.ru/oneplatform-frontend/speed-tracking"
  :dependencies [[org.clojure/clojure "1.10.3"]
                 [com.novemberain/monger "3.5.0"]
                 [compojure "1.6.2" :exclusions [ring/ring-codec]]
                 [environ "1.2.0"]
                 [ring/ring-core "1.9.5"]
                 [ring/ring-devel "1.9.5"]
                 [ring/ring-jetty-adapter "1.9.5"]
                 [ring/ring-json "0.5.1"]]
  :min-lein-version "2.0.0"
  :plugins [[lein-environ "1.2.0"]]
  :main ^:skip-aot speed-tracking.core
  :uberjar-name "speed-tracking-standalone.jar")
