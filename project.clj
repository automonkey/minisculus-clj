(defproject minisculus-clj "0.1.0-SNAPSHOT"
  :description "Minisculus challenge entry in clojure (http://minisculuschallenge.com/index.html)"
  :url "https://github.com/automonkey/minisculus-clj"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]]
  :main ^:skip-aot minisculus-clj.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
