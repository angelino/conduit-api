(defproject conduit-api "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [ring "1.6.3"]
                 [ring/ring-json "0.4.0"]
                 [compojure "1.6.0"]
                 [camel-snake-kebab "0.4.0"]]
  :main conduit-api.core
  :profiles {:dev {:source-paths ["src" "dev"]
                   :main conduit-api.dev}
             :uberjar {:aot :all}}
  :min-lein-version "2.0.0"
  :uberjar-name "conduit-api.jar")
