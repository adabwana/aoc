^{:nextjournal.clerk/visibility :hide-ns}
(ns solutions.2015.day01
    (:require
        [clojure.java.io :as io]
        [nextjournal.clerk :as clerk]
        [util :as u]))

^{::clerk/viewer :html ::clerk/visibility :hide}
(u/css)

{:nextjournal.clerk/visibility {:code :hide :result :show}}
(clerk/html (u/load-problem "01" "2015"))
{:nextjournal.clerk/visibility {:code :show :result :show}}

;; # Solution

(def input (->> (slurp (io/resource "inputs/2015/day01.txt")))) ;; Load the resource


{:nextjournal.clerk/visibility {:result :hide}}
(defn part-1 [input]
  (let [floors (reductions + (map #(if (= % \() 1 -1) input))]
    (println (last floors)))) ;; part 1

;; Which gives our answer
{:nextjournal.clerk/visibility {:code :hide :result :show}}
(part-1 input)

{:nextjournal.clerk/visibility {:code :show :result :hide}}
(defn part-2 [input]
  (let [floors (reductions + (map #(if (= % \() 1 -1) input))
        first-basement (inc (.indexOf floors -1))]
    (println first-basement))) ;; part 2

;; Which gives our answer
{:nextjournal.clerk/visibility {:code :hide :result :show}}
(part-2 input)

(defn what-floor [paren-str]
  (let [floors (reductions + (map #(if (= % \() 1 -1) paren-str))
        first-basement (inc (.indexOf floors -1))]
      (println (last floors)) ;; part 1
      (println first-basement))) ;; part 2