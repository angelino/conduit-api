(ns conduit-api.profile.handler)

(defn handle-profile [req]
  {:status 200
   :headers {}
   :body {:profile {:username "jake"
                    :bio "I work at statefarm"
                    :image "https://static.productionready.io/images/smiley-cyrus.jpg"
                    :fallowing false}}})

(defn handle-follow [req]
  {:status 200
   :headers {}
   :body {:profile {:username "jake"
                    :bio "I work at statefarm"
                    :image "https://static.productionready.io/images/smiley-cyrus.jpg"
                    :fallowing true}}})

(defn handle-unfollow [req]
  {:status 200
   :headers {}
   :body {:profile {:username "jake"
                    :bio "I work at statefarm"
                    :image "https://static.productionready.io/images/smiley-cyrus.jpg"
                    :fallowing false}}})
