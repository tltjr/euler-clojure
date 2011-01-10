(defn transform [n]
  (if (even? n)
    (/ n 2)
    (inc (* n 3))))

(def memo-transform (memoize transform))

;; Memoization made an unbelievable difference
;; Before:
;; Clojure=> (time (map itseq (range 1 201)))
;; "Elapsed time: 0.435738 msecs"
;; After:
;; Clojure=> (time (map itseq (range 1 201)))
;; "Elapsed time: 0.036946 msecs"

(defn itseq [n]
  (loop [m n cnt 0]
    (if (= m 1)
        [(inc cnt) n]
      (recur (memo-transform m) (inc cnt)))))

;; be prepared to take a nap when you run this
(reduce #(if (> (first %1) (first %2)) %1 %2) (map itseq (range 1 1000000)))
