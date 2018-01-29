(ns conduit-api.core
  (:require [ring.adapter.jetty :as jetty]))

(defn app [req]
  {:status 200
   :headers {}
   :body "It's running!!!"})

(defn -main [port]
  (jetty/run-jetty app {:port (Integer. port)}))
