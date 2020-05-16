(ns app.dashboard
  (:require [reagent.core :refer [atom]]))

(def state (atom {:address "one1x8kgyyqgslzrm7jrlj4m7rpg285etdywjk7gez"
                  :comitee true
                  :top-data {:balance "120" :return "20.29" :uptime "98.56" :rewards "60,49" :delegators-head "17"}
                  :general {:name "Zgen Validator" :desc "Little this little that" :site "zgen.hu" :details "idk" :contact "crypto@zgen.hu" :comission "15.15%" :max-del "100,000,000"}
                  :delegators [{:address "one1x8kgyyqgslzrm7jrlj4m7rpg285etdywjk7gez" :amount "2,450,000" :reward "34.533"}
                               {:address "one1vyd0rgpspyjme3ufrvlmk8mza8ez929ngtamlj" :amount "1,000,000" :reward "21.89"}
                               {:address "one1uq5fys06g3rvmrxj2q0acd9e2fzjd54ctjj9xj" :amount "100,000" :reward "43.23"}
                               {:address "one1mpzx5wr2kmz9nvkhsgj6jr6zs87ahm0gxmhlck" :amount "20,000" :reward "2.33"}
                               {:address "one159h80syujml77x03mgd3p4ehck6pderfnazrkv" :amount "20,000" :reward "4.67"}
                               {:address "one1qtx776yews0t80k9ppe6d2qd76clnpp2tjs8wt" :amount "10,000" :reward "5.21"}
                               {:address "one1ku37y4dhlzjmejjc5mghtfts988tp0qxfhu2hq" :amount "10,000" :reward "9.99"}
                               {:address "one159h80syujml77x03mgd3p4ehck6pderfnazrkv" :amount "20,000" :reward "4.67"}
                               {:address "one1qtx776yews0t80k9ppe6d2qd76clnpp2tjs8wt" :amount "10,000" :reward "5.21"}
                               {:address "one1ku37y4dhlzjmejjc5mghtfts988tp0qxfhu2hq" :amount "10,000" :reward "9.99"}
                               {:address "one159h80syujml77x03mgd3p4ehck6pderfnazrkv" :amount "20,000" :reward "4.67"}
                               {:address "one1qtx776yews0t80k9ppe6d2qd76clnpp2tjs8wt" :amount "10,000" :reward "5.21"}
                               {:address "one1ku37y4dhlzjmejjc5mghtfts988tp0qxfhu2hq" :amount "10,000" :reward "9.99"}]
                  :stake {:total "49,750,520" :delegated "47,300,520" :self "2,450,000"}}))

(defn comitee []
  (if (:comitee @state)
    [:div
     [:span.dot]
     [:p "Currently elected"]]
    [:div
     [:div.dot.orange]
     [:p "Waiting to be selected"]]))

(defn app []
  [:div
   [:header
    [:img {:src "/images/header-logo.png"}]
    [:div
     [:div
      [:p "Address:"]
      [:a (@state :address)]]
     (comitee)]]

   [:div.top-data
    [:div.first
     [:p "Balance"]
     [:p.value (get-in @state [:top-data :balance]) [:span "ONE"]]]
    [:div
     [:p "Expected Return"]
     [:p.value (get-in @state [:top-data :return]) [:span "%"]]]
    [:div
     [:p "Uptime (AVG)"]
     [:p.value (get-in @state [:top-data :uptime]) [:span "%"]]]
    [:div
     [:p "Lifetime Rewards"]
     [:p.value (get-in @state [:top-data :rewards]) [:span "ONE"]]]
    [:div.last
     [:p "Delegators"]
     [:p.value (get-in @state [:top-data :delegators-head]) [:span "HEAD"]]]]

   [:div.info-titles
    [:p "General info"]
    [:p "Delegators"]]
   [:div.info
    [:div.general
     [:div.card
      [:div
       [:label "Validator Name"]
       [:input {:value (get-in @state [:general :name])}]]
      [:div.columns
       [:div.column
        [:div
         [:label "Description"]
         [:input {:value (get-in @state [:general :desc])}]]
        [:div
         [:label "Details"]
         [:input {:value (get-in @state [:general :details])}]]
        [:div
         [:label "Comission Rate"]
         [:input {:value (get-in @state [:general :comission])}]]]
       [:div.column
        [:div
         [:label "Website"]
         [:input {:value (get-in @state [:general :site])}]]
        [:div
         [:label "Security Contact"]
         [:input {:value (get-in @state [:general :contact])}]]
        [:div
         [:label "Max Total Delegation"]
         [:input {:value (get-in @state [:general :max-del])}]]]]
      [:div.btn-wrapper
       [:div.save-btn "Save Changes"]]]]

    [:div.delegators
     [:div.card
      [:div.head-row
       [:div.number [:p "No."]]
       [:div.addres [:p "Address"]]
       [:div.amount [:p "Amount"]]
       [:div.reward [:p "Reward"]]]
      (for [delegator (map-indexed vector (@state :delegators))]
        [:div.row {:class (when (even? (first delegator)) "light-bg")}
         [:div.number [:p (inc (first delegator))]]
         [:div.addres [:a ((second delegator) :address)]]
         [:div.amount [:p ((second delegator) :amount)]]
         [:div.reward [:p ((second delegator) :reward)]]])]
     [:div.stake-data
      [:div.first
       [:p "Total Staked"]
       [:p.value (get-in @state [:stake :total]) [:span "ONE"]]]
      [:div
       [:p "Delegated"]
       [:p.value (get-in @state [:stake :delegated] [:span "ONE"])]]
      [:div.last
       [:p "Self Stake"]
       [:p.value (get-in @state [:stake :self] [:span "ONE"])]]]]]

   [:footer
    [:div
     [:p "Don't forget to donate some ONE or ETH to the ZGEN DAO to support our further work:"]
     [:a "0xAAA77711c7b70e20d32Ec50b21Df89e742607b9b"]]
    [:div
     [:p "Send your feature requests to:"]
     [:a "crypto@zgen.hu"]]
    [:div
     [:p "Source:"]
     [:a {:href "google.com"} "liszper/one-validator-dashboard"]]]])
