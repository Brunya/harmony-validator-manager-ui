(ns app.core
  (:require [reagent.core :as r]
            [app.dashboard :refer [app]]
            [app.login :refer [login-view]]))

(defn ^:dev/after-load start
  []
  (r/render-component [app]
                      (.getElementById js/document "app")))

(defn ^:export main
  []
  (start))
