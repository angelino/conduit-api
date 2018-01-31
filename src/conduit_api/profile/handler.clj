(ns conduit-api.profile.handler
  (:require [ring.util.response :refer [response]]))

(defn handle-profile [req]
  (response {:profile {:username "jake"
                       :bio "I work at statefarm"
                       :image "https://static.productionready.io/images/smiley-cyrus.jpg"
                       :fallowing false}}))

(defn handle-follow [req]
  (response {:profile {:username "jake"
                       :bio "I work at statefarm"
                       :image "https://static.productionready.io/images/smiley-cyrus.jpg"
                       :fallowing false}}))

(defn handle-unfollow [req]
  (response {:profile {:username "jake"
                       :bio "I work at statefarm"
                       :image "https://static.productionready.io/images/smiley-cyrus.jpg"
                       :fallowing false}}))
