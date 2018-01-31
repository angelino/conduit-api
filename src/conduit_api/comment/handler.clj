(ns conduit-api.comment.handler
  (:require [ring.util.response :refer [response]]))

(defn handle-index-comments [req]
  (response {:comments [{:id 1
                         :created-at #inst "2016-02-18T03:22:56.637Z"
                         :updated-at #inst "2016-02-18T03:22:56.637Z"
                         :body "It takes a Jacobian"
                         :author {:username "jake"
                                  :bio "I work at statefarm"
                                  :image "https://i.stack.imgur.com/xHWG8.jpg"
                                  :following false}}]}))

(defn handle-create-comment [req]
  (response {:comment {:id 1
                       :created-at #inst "2016-02-18T03:22:56.637Z"
                       :updated-at #inst "2016-02-18T03:22:56.637Z"
                       :body "It takes a Jacobian"
                       :author {:username "jake"
                                :bio "I work at statefarm"
                                :image "https://i.stack.imgur.com/xHWG8.jpg"
                                :following false}}}))

(defn handle-delete-comment [req]
  (response {}))
