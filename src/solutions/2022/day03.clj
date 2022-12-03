(ns solutions.2022.day03
  (:require [clojure.java.io :as io]
            [clojure.test :as t :refer [deftest]]
            [clojure.string :as str]
            [clojure.set :as set]))

(def input (->> (slurp (io/resource "inputs/2022/day03.txt"))
                (str/split-lines)))

(defn get-priority [item]
  (- (int item)
     (if (= (str item) (str/upper-case item))
       38
       96)))

(defn split-rucksack [rucksack]
  (partition (/ (count rucksack) 2) rucksack))

(defn check-items [rucksacks]
  (first (apply set/intersection (map set rucksacks))))

(defn part-1
  [input]
  (transduce (map (comp get-priority check-items split-rucksack)) + 0 input))

(defn part-2
  [input]
  (transduce (map (comp get-priority check-items)) + 0 (partition 3 input)))

(deftest test-answers
  (t/is (= 7845 (part-1 input)))
  (t/is (= 2790 (part-2 input))))