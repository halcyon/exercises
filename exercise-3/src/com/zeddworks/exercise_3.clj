(ns com.zeddworks.exercise-3
  (:require [clojure.pprint :as pprint])
  (:gen-class))

(defn word-frequencies
  [filename]
  (reduce (fn word-freq-rf [acc input]
            (->> (acc input 0)
                 inc
                 (assoc acc input)))
          {}
          (re-seq #"\w+" (slurp filename))))

(defn -main
  [& args]
  (if-let [[filename] args]
    (pprint/pprint (word-frequencies filename))
    (do
      (println "Word Frequencies")
      (println "Usage: clojure -m com.zeddworks.exercise-3 [filename]"))))
