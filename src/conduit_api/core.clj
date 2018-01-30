(ns conduit-api.core
  (:require [ring.adapter.jetty :as jetty]
            [ring.middleware.json :refer [wrap-json-response]]
            [compojure.core :refer [defroutes GET POST]]
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
  (not-found "Page not found!"))

(def app 
  (-> routes
      wrap-json-response))

(defn -main [port]
  (jetty/run-jetty app {:port (Integer. port)}))
