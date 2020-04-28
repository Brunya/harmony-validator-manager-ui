(ns app.login)

(defn login-view []
  [:login-screen
   [:div
    [:img {:src "/images/logo.png"}]
    [:password
     [:input {:placeholder "Password"}]
     [:login-btn [:img {:src "/images/arrow.svg"}]]]]])
