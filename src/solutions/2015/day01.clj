^{:nextjournal.clerk/visibility :hide-ns}
(ns solutions.2015.day01
    (:require
        [clojure.java.io :as io]
        [clojure.string :as str]
        [nextjournal.clerk :as clerk]
        [util :as u]))

^{::clerk/viewer :html ::clerk/visibility :hide}
(u/css)

{:nextjournal.clerk/visibility {:code :hide :result :show}}
(clerk/html (u/load-problem "01" "2015"))
{:nextjournal.clerk/visibility {:code :show :result :show}}

;; # Solution
(defn read-input  [file-name]
  (slurp file-name))

(defn what-floor [paren-str]
  (let [floors (reductions + (map #(if (= % \() 1 -1) paren-str))
        first-basement (inc (.indexOf floors -1))]
      (println (last floors)) ;; part 1
      (println first-basement))) ;; part 2

;(def input (read-input "./data/day-1.txt"))

;(what-floor input)