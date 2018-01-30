(ns conduit-api.user.handler)

(defn handle-create-user [req]
  {:status 200
   :headers {}
   :body {:user {:email "jake@jake.com"
                 :token "jwt.token.here"
                 :username "jake"
                 :bio "I work at statefarm"
                 :image ""}}})

(defn handle-show-current-user [req]
  {:status 200
   :headers {}
   :body {:user {:email "jake@jake.com"
                 :token "jwt.token.here"
                 :username "jake"
                 :bio "I work at statefarm"
                 :image ""}}})

(defn handle-update-user [req]
  {:status 200
   :headers {}
   :body {:user {:email "jake@jake.com"
                 :token "jwt.token.here"
                 :username "jake"
                 :bio "I work at statefarm"
                 :image ""}}})

(defn handle-login [req]
  {:status 200
   :headers {}
   :body {:user {:email "jake@jake.com"
                 :token "jwt.token.here"
                 :username "jake"
                 :bio "I work at statefarm"
                 :image ""}}})
