(use 'clojure.contrib.seq-utils)

;; (defn triangle [n]
;;   (if (= n 1)
;;     1
;;     (+ n (triangle (dec n)))))

(defn triangle [n]
  (defn rec [n acc]
    (if (= n 1)
      acc
      (recur (dec n) (+ acc n))))
  (rec n 1))

(def tri-nums (map #(triangle %) (iterate #(inc %) 1)))

(defn divisor? [x n]
  (zero? (mod x n)))

(defn num-divisors [n]
  (count (filter #(divisor? n %) (range 1 (inc n)))))

(find-first #(> % 500) (map num-divisors tri-nums))

