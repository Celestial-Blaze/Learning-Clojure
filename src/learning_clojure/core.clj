(ns learning-clojure.core
  (:require [learning-clojure.algorithms :as algo]))

;(defn greet []
;      (println "Hello, World!"))

(defn -main []
    (println "Sorted result:" (algo/merge-sort [8 3 5 2 9 1]))
    (println "Sorted result:" (algo/merge-sort []))
    (println "Sorted result:" (algo/merge-sort [1]))
    (println "Sorted result:" (algo/merge-sort [1 2 3 4 5 6]))
    (println "Sorted result:" (algo/merge-sort [100 294 1 12 -5 9 37 42 0]))
  )