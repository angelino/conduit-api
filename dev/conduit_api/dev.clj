(ns conduit-api.dev
  (:require [ring.adapter.jetty :as jetty]
            [ring.middleware.reload :refer [wrap-reload]]
            [conduit-api.core :as core]))

(defn -main [port]
  (jetty/run-jetty (wrap-reload #'core/app) {:port (Integer. port)}))
