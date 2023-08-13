^{:nextjournal.clerk/visibility :hide-ns}
(ns solutions.2015.day02
    (:require
        [clojure.java.io :as io]
        [clojure.string :as str]
        [nextjournal.clerk :as clerk]
        [util :as u]))
{:nextjournal.clerk/visibility {:code :show :result :show}}

^{::clerk/viewer :html ::clerk/visibility :hide}
(u/css)

{:nextjournal.clerk/visibility {:code :hide :result :show}}
(clerk/html (u/load-problem "02" "2015"))
{:nextjournal.clerk/visibility {:code :show :result :show}}

;; ## Solution

(defn read-input  [file-name]
  (vec (map string/trim-newline (string/split (slurp file-name) #"\n"))))

(defn wrap-per-box [dim-str]
  (let [str-nums (vec (map #(Integer/parseInt %) (string/split dim-str #"x")))
        l (first str-nums)
        w (second str-nums)
        h (last str-nums)
        surface-area (* 2 (+ (* l w) (* l h) (* w h)))
        sort-str-nums (sort str-nums)
        small-two-mult (reduce * (take 2 sort-str-nums))]
    (+ surface-area small-two-mult)))

(def input (read-input "./data/day-2.txt"))

(wrap-per-box input)