(ns minisculus-clj.core
  (:gen-class)
  (:require [minisculus-clj.questions :as questions]
            [minisculus-clj.decoder :as decoder]))

(defn- print-question [question]
  (println "Question 1:" question))

(defn- print-answer [answer]
  (println "Question 1 answer:" answer))

(defn -main
  [& args]
  (let [first-question (questions/first-question)
        decoder-shift-setting 6]
    (print-question first-question)
    (print-answer (->> (get first-question "question")
                       (decoder/decoded-string decoder-shift-setting)))))
