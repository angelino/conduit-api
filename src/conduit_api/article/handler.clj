(ns conduit-api.article.handler
  (:require [ring.util.response :refer [response]]))

(defn handle-show-article [req]
  (response {:article {:slug "how-to-train-your-dragon"
                       :title "How to train your dragon"
                       :description "Ever wonder how?"
                       :body "It takes a Jacobian"
                       :tag-list ["dragons", "training"]
                       :created-at #inst "2016-02-18T03:22:56.637Z"
                       :updated-at #inst "2016-02-18T03:48:35.824Z"
                       :favorited false
                       :favorites-count 0
                       :author {:username "jake"
                                :bio "I work at statefarm"
                                :image "https://i.stack.imgur.com/xHWG8.jpg"
                                :following false}}}))

(defn handle-index-articles [req]
  (response {:articles [{:slug "how-to-train-your-dragon"
                         :title "How to train your dragon"
                         :description "Ever wonder how?"
                         :body "It takes a Jacobian"
                         :tag-list ["dragons", "training"]
                         :created-at #inst "2016-02-18T03:22:56.637Z"
                         :updated-at #inst "2016-02-18T03:48:35.824Z"
                         :favorited false
                         :favorites-count 0
                         :author {:username "jake"
                                  :bio "I work at statefarm"
                                  :image "https://i.stack.imgur.com/xHWG8.jpg"
                                  :following false}}
                        {:slug "how-to-train-your-dragon-2"
                         :title "How to train your dragon 2"
                         :description "So toothless"
                         :body "It's a dragon"
                         :tag-list ["dragons", "training"]
                         :created-at #inst "2016-02-18T03:22:56.637Z"
                         :updated-at #inst "2016-02-18T03:48:35.824Z"
                         :favorited false
                         :favorites-count 0
                         :author {:username "jake"
                                  :bio "I work at statefarm"
                                  :image "https://i.stack.imgur.com/xHWG8.jpg"
                                  :following false}}]
             :articles-count 2}))

(defn handle-feed-articles [req]
  (response {:articles [{:slug "how-to-train-your-dragon"
                         :title "How to train your dragon"
                         :description "Ever wonder how?"
                         :body "It takes a Jacobian"
                         :tag-list ["dragons", "training"]
                         :created-at #inst "2016-02-18T03:22:56.637Z"
                         :updated-at #inst "2016-02-18T03:48:35.824Z"
                         :favorited false
                         :favorites-count 0
                         :author {:username "jake"
                                  :bio "I work at statefarm"
                                  :image "https://i.stack.imgur.com/xHWG8.jpg"
                                  :following false}}
                        {:slug "how-to-train-your-dragon-2"
                         :title "How to train your dragon 2"
                         :description "So toothless"
                         :body "It's a dragon"
                         :tag-list ["dragons", "training"]
                         :created-at #inst "2016-02-18T03:22:56.637Z"
                         :updated-at #inst "2016-02-18T03:48:35.824Z"
                         :favorited false
                         :favorites-count 0
                         :author {:username "jake"
                                  :bio "I work at statefarm"
                                  :image "https://i.stack.imgur.com/xHWG8.jpg"
                                  :following false}}]
             :articles-count 2}))

(defn handle-create-article [req]
  (response {:article {:slug "how-to-train-your-dragon"
                       :title "How to train your dragon"
                       :description "Ever wonder how?"
                       :body "It takes a Jacobian"
                       :tag-list ["dragons", "training"]
                       :created-at #inst "2016-02-18T03:22:56.637Z"
                       :updated-at #inst "2016-02-18T03:48:35.824Z"
                       :favorited false
                       :favorites-count 0
                       :author {:username "jake"
                                :bio "I work at statefarm"
                                :image "https://i.stack.imgur.com/xHWG8.jpg"
                                :following false}}}))

(defn handle-update-article [req]
  (response {:article {:slug "how-to-train-your-dragon"
                       :title "How to train your dragon"
                       :description "Ever wonder how?"
                       :body "It takes a Jacobian"
                       :tag-list ["dragons", "training"]
                       :created-at #inst "2016-02-18T03:22:56.637Z"
                       :updated-at #inst "2016-02-18T03:48:35.824Z"
                       :favorited false
                       :favorites-count 0
                       :author {:username "jake"
                                :bio "I work at statefarm"
                                :image "https://i.stack.imgur.com/xHWG8.jpg"
                                :following false}}}))

(defn handle-delete-article [req]
  (response))
