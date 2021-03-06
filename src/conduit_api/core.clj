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
                                                 handle-delete-article
                                                 handle-favorite-article
                                                 handle-unfavorite-article]]
            [conduit-api.comment.handler :refer [handle-index-comments
                                                 handle-create-comment
                                                 handle-delete-comment]]
            [conduit-api.tag.handler :refer [handle-index-tags]])
  (:gen-class))

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
  (POST "/api/articles/:slug/favorite" [] handle-favorite-article)
  (DELETE "/api/articles/:slug/favorite" [] handle-favorite-article)

  (GET "/api/articles/:slug/comments" [] handle-index-comments)
  (POST "/api/articles/:slug/comments" [] handle-create-comment)
  (DELETE "/api/articles/:slug/comments/:id" [] handle-delete-comment)

  (GET "/api/tags" [] handle-index-tags)

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

(defn -main [& args]
  (let [port (Integer. (or (first args) 3000))]
    (println (str "The server is running on: http://localhost:" port))
    (jetty/run-jetty app {:port port})))
