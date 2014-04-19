(ns minisculus-clj.questions
  (:require [clj-http.client :as http-client]
            [clojure.data.json :as json]))

(defn first-question []
  (-> (http-client/get
       "http://minisculuschallenge.com/14f7ca5f6ff1a5afb9032aa5e533ad95")
      :body
      (json/read-str)))
