(ns conduit-api.core
  (:require [ring.adapter.jetty :as jetty]
            [compojure.core :refer [defroutes GET]]
            [compojure.route :refer [not-found]]))

(defn hello-world [req]
  {:status 200
   :headers {}
   :body "It's running!!!"})

(defroutes routes
  (GET "/" [] hello-world)
  (not-found "Page not found!"))

(def app 
  routes)

(defn -main [port]
  (jetty/run-jetty app {:port (Integer. port)}))
