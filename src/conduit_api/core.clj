(ns conduit-api.core
  (:require [ring.adapter.jetty :as jetty]
            [ring.middleware.params :refer [wrap-params]]
            [ring.middleware.json :refer [wrap-json-params
                                          wrap-json-response]]
            [ring.handler.dump :refer [handle-dump]]
            [compojure.core :refer [defroutes ANY GET POST PUT DELETE]]
            [compojure.route :refer [not-found]]
            [camel-snake-kebab.core :refer [->camelCaseKeyword]]
            [camel-snake-kebab.extras :refer [transform-keys]]
            [conduit-api.user.handler :refer [handle-login
                                              handle-create-user
                                              handle-update-user
                                              handle-show-current-user]]
            [conduit-api.profile.handler :refer [handle-profile
                                                 handle-follow
                                                 handle-unfollow]]
            [conduit-api.article.handler :refer [handle-show-article
                                                 handle-index-articles
                                                 handle-feed-articles
                                                 handle-create-article
                                                 handle-update-article
                                                 handle-delete-article]]))

(defn hello-world [req]
  {:status 200
   :headers {}
   :body "It's running!!!"})

(defroutes routes
  (GET "/" [] hello-world)

  (POST "/api/users/login" [] handle-login)
  (POST "/api/users" [] handle-create-user)
  (GET "/api/user" [] handle-show-current-user)
  (PUT "/api/user" [] handle-update-user)

  (GET "/api/profiles/:username" [] handle-profile)
  (POST "/api/profiles/:username/follow" [] handle-follow)
  (DELETE "/api/profiles/:username/follow" [] handle-unfollow)

  (GET "/api/articles" [] handle-index-articles)
  (GET "/api/articles/feed" [] handle-feed-articles)
  (GET "/api/articles/:slug" [] handle-show-article)
  (POST "/api/articles" [] handle-create-article)
  (PUT "/api/articles/:slug" [] handle-update-article)
  (DELETE "/api/articles/:slug" [] handle-delete-article)

  (ANY "/request" [] handle-dump)
  (not-found "Page not found!"))

(defn wrap-json-camelcase-keys [handler]
  (fn [req]
    (let [resp (handler req)
          result (transform-keys ->camelCaseKeyword (:body resp))]
      (assoc-in resp [:body] result))))

(def app 
  (-> routes
      wrap-params
      wrap-json-params
      wrap-json-camelcase-keys
      wrap-json-response))

(defn -main [port]
  (jetty/run-jetty app {:port (Integer. port)}))
