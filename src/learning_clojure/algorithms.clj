(ns learning-clojure.algorithms)

(defn merge-sorted [left right]                             ; cause it's functional y'know
  (cond                                                     ; supposedly pattern matching
    (empty? left) right
    (empty? right) left
    :else (let [l (first left)
                r (first right)]
            (if (<= l r)
              (cons l (merge-sorted (rest left) right))
              (cons r (merge-sorted left (rest right)))
              )
            )
    )
  )
; this language sucks when it comes to "did I put enough parentheses?"
; highly recommend using an IDE or indentation & comments will be a nightmare
(defn merge-sort [coll]
  (let [n (count coll)]
    (if (<= n 1)
      coll
      (let [mid (quot n 2)
            left (subvec (vec coll) 0 mid)
            right (subvec (vec coll) mid n)]
        (merge-sorted (merge-sort left) (merge-sort right)))
      )
    )
  )
