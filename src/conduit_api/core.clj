(ns conduit-api.core
  (:require [ring.adapter.jetty :as jetty]
            [ring.middleware.params :refer [wrap-params]]
            [ring.middleware.json :refer [wrap-json-params
                                          wrap-json-response]]
            [ring.handler.dump :refer [handle-dump]]
            [compojure.core :refer [defroutes ANY GET POST PUT]]
            [compojure.route :refer [not-found]]
            [conduit-api.user.handler :refer [handle-create-user
                                              handle-update-user
                                              handle-show-current-user]]))

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

(defn handle-profile [req]
  {:status 200
   :headers {}
   :body {:profile {:username "jake"
                    :bio "I work at statefarm"
                    :image "https://static.productionready.io/images/smiley-cyrus.jpg"
                    :fallowing false}}})

(defroutes routes
  (GET "/" [] hello-world)

  (POST "/api/users/login" [] handle-login)
  (POST "/api/users" [] handle-create-user)
  (GET "/api/user" [] handle-show-current-user)
  (PUT "/api/user" [] handle-update-user)
  (GET "/api/profiles/:username" [] handle-profile)
  (ANY "/request" [] handle-dump)
  (not-found "Page not found!"))

(def app 
  (-> routes
      wrap-params
      wrap-json-params
      wrap-json-response))

(defn -main [port]
  (jetty/run-jetty app {:port (Integer. port)}))
