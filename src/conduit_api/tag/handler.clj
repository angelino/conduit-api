(ns conduit-api.tag.handler
  (:require [ring.util.response :refer [response]]))

(defn handle-index-tags [req]
  (response {:tags [ "reactjs" "angularjs"]}))
