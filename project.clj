(defproject speed-tracking "0.1.0-SNAPSHOT"
  :description "..."
  :url "https://gitlab.kodixauto.ru/oneplatform-frontend/speed-tracking"
  :dependencies [[org.clojure/clojure "1.10.3"]]
  :main ^:skip-aot speed-tracking.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})
