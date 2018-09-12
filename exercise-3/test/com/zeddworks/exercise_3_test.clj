(ns com.zeddworks.exercise-3-test
  (:require [clojure.test :refer :all]
            [com.zeddworks.exercise-3 :refer :all]))

(deftest word-frequencies-test
  (is (= (frequencies (re-seq #"\w+" (slurp "README.md")))
         (word-frequencies "README.md"))))
