(ns learning-clojure.algorithms)

(defn merge-sorted [left right]                             ; this one merges sorted sub "collections"
  (cond                                                     ; this is supposed to be a pattern matching technique
    (empty? left) right
    (empty? right) left
    :else (let [l (first left)                              ; in case the patterns above don't match
                r (first right)]
            (if (<= l r)                                    ; prefix notation
              (cons l (merge-sorted (rest left) right))     ; uses the built-in cons function
              (cons r (merge-sorted left (rest right)))
              )
            )
    )
  ) ; highly recommend using an IDE, otherwise indentation, parentheses counting, and comments will be a nightmare

(defn merge-sort [coll]
  (let [n (count coll)]                                     ; coll = collection, any sequential data structure
    (if (<= n 1)                                            ; n is the length of the collection
      coll                                                  ; base case, collection is sorted
      (let [mid (quot n 2)                                  ; vec = vector, a data type
            left (subvec (vec coll) 0 mid)                  ; defining mid, left, right
            right (subvec (vec coll) mid n)]
        (merge-sorted (merge-sort left) (merge-sort right))); recursively merge sort the left & right halves
      )
    )
  )
