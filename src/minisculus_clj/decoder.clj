(ns minisculus-clj.decoder
  (:use midje.sweet))

(def minisculus-chars [
                       \0 \1 \2 \3 \4 \5 \6 \7 \8 \9
                       \A \B \C \D \E \F \G \H \I \J \K \L \M
                       \N \O \P \Q \R \S \T \U \V \W \X \Y \Z
                       \a \b \c \d \e \f \g \h \i \j \k \l \m
                       \n \o \p \q \r \s \t \u \v \w \x \y \z
                       \. \, \? \! \' \\ \space
  ])

(defn- decoded-char [shift-setting char]
  (->> (.indexOf minisculus-chars char)
       (+ shift-setting)
       (nth (cycle minisculus-chars))))

(facts "about decoded-char"
  (fact "is input shifted by shift-setting"
    (decoded-char 1 \0) => \1
    (decoded-char 2 \A) => \C)
  (fact "wraps when input at end of buffer"
    (decoded-char 1 \space) => \0))

(defn decoded-string [shift-setting coded-string]
  (apply str (map (partial decoded-char shift-setting) coded-string)))

(fact "decoded string is all chars shifted by shift-setting"
  (let [shift-setting 5]
    (decoded-string shift-setting "0ANan.")) => "5FSfs\\")
