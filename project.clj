(defproject speed-tracking "0.1.0-SNAPSHOT"
  :description "Websites loading speed tracking app"
  :url "https://gitlab.kodixauto.ru/oneplatform-frontend/speed-tracking"
  :dependencies [[org.clojure/clojure "1.10.3"]
                 [compojure "1.6.2" :exclusions [ring/ring-codec]]
                 [ring/ring-core "1.9.4"]
                 [ring/ring-jetty-adapter "1.9.4"]]
  :main ^:skip-aot speed-tracking.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})
