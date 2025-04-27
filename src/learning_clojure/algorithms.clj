(ns learning-clojure.algorithms)

;; Binary search function using recursion
(defn binary-search [vector, value] ; Use Kebab-case for function names with Clojure

  (if (empty? vector) ; Checking if the vector is empty -- if it is, return false
    false ; Then expression - return false, the value is not in the list

    (let [vector-length (count vector), pivot-index (quot vector-length 2), pivot (nth vector pivot-index)] ; Finding the middle element
      ;; (println "\n-------------------------")
      ;; (println "Current Vector: " vector)
      ;; (println "Pivot-index: " pivot-index)
      ;; (println "Pivot in Vector: " pivot)

      ; Using a cond bc there's multiple options
      (cond
        ;; If the pivot is the value we're looking for, return true
        (= value pivot) true

        ; If the pivot is less than the value, search the left side of the list
        (< value pivot)
        (do ; Add a do so Clojure knows it should run the following lines
          ;; (println "Searching left...")
          (binary-search (subvec vector 0 pivot-index) value)
          )
        (> value pivot) ; Don't keep the (let...) on this line...Clojure freaks out
        (let [new-right-index (+ pivot-index 1)
              right-vector (subvec vector new-right-index vector-length)]

          ;; (println "Searching right...")
          ;; (println "New right vector: " right-vector)
          (binary-search right-vector value)
          )
        ;; :else false ; Don't really need
        ))))


;; Merge Sort
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
