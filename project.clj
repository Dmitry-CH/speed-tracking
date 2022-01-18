(defproject speed-tracking "0.1.0-SNAPSHOT"
  :description "Websites loading speed tracking app"
  :url "https://gitlab.kodixauto.ru/oneplatform-frontend/speed-tracking"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.10.3"]
                 [com.novemberain/monger "3.1.0"]
                 [compojure "1.6.2" :exclusions [ring/ring-codec]]
                 [ring/ring-core "1.9.4"]
                 [ring/ring-devel "1.9.4"]
                 [ring/ring-jetty-adapter "1.9.4"]
                 [ring/ring-json "0.5.1"]]
  :main ^:skip-aot speed-tracking.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})
