(ns conduit-api.core
  (:require [ring.adapter.jetty :as jetty]
            [ring.middleware.params :refer [wrap-params]]
            [ring.middleware.json :refer [wrap-json-params
                                          wrap-json-response]]
            [ring.handler.dump :refer [handle-dump]]
            [compojure.core :refer [defroutes ANY GET POST]]
            [compojure.route :refer [not-found]]))

(defn hello-world [req]
  {:status 200
   :headers {}
   :body "It's running!!!"})

(defn handle-login [req]
  {:status 200
   :headers {}
   :body {:user {:email "jake@jake.com"
                 :token "jwt.token.here"
                 :username "jake"
                 :bio "I work at statefarm"
                 :image ""}}})

(defroutes routes
  (GET "/" [] hello-world)

  (POST "/api/users/login" [] handle-login)
  (ANY "/request" [] handle-dump)
  (not-found "Page not found!"))

(def app 
  (-> routes
      wrap-params
      wrap-json-params
      wrap-json-response))

(defn -main [port]
  (jetty/run-jetty app {:port (Integer. port)}))
