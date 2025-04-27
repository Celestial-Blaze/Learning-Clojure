(ns learning-clojure.core
  (:require [learning-clojure.algorithms :as algo]))


(defn -main []
  ;; Calling binary search
  (println"----------")
  (println "\nLooking for 3 in [1, 2, 3, 4, 5]..." (algo/binary-search [1, 2, 3, 4, 5] 3))
  (println "\nLooking for 2 in [1, 2, 3, 4]..." (algo/binary-search [1, 2, 3, 4] 2))
  (println "\nLooking for 4 in [1, 2, 3, 4]..." (algo/binary-search [1, 2, 3, 4] 4))
  (println "\nLooking for -24 in [17, 24, 31]..." (algo/binary-search [17, 24, 31] -24))
  (println "\nLooking for 15 in [11, 22, 33, 44]..." (algo/binary-search [11, 22, 33, 44] 15))
  (println "\nLooking for 42 in [42]..." (algo/binary-search [42] 42))
  (println "\nLooking for 99 in []..." (algo/binary-search [] 99))
  (println "\nLooking for 2 in [1, 2, 2, 3, 4]..." (algo/binary-search [1, 2, 2, 3, 4] 2))
  (println "\nLooking for 10099 in [12, 25, 68, 89, 109, 111, 1029, 10098]..." (algo/binary-search [12, 25, 68, 89, 109, 111, 1029, 10098] 10099))
  (println "\nLooking for -15 in [-24, -20, -19, -18, -17, -16, 22, 33, 44]..." (algo/binary-search [-24, -20, -19, -18, -17, -16, 22, 33, 44] -15))
  ;; Calling Merge-Sort
  (println "Sorted result:" (algo/merge-sort [8 3 5 2 9 1]))
  (println "Sorted result:" (algo/merge-sort []))
  (println "Sorted result:" (algo/merge-sort [1]))
  (println "Sorted result:" (algo/merge-sort [1 2 3 4 5 6]))
  (println "Sorted result:" (algo/merge-sort [100 294 1 12 -5 9 37 42 0]))
  )