(ns euler.21)

(defn divisors [n]
  (filter #(zero? (rem n %)) (range 1 n)))

(defn d [n]
  (reduce + (divisors n)))

(defn n-with-d [n]
  [n (d n)])

(defn amicable? [v]
  (let [a (ffirst v) 
        b (second (first v))
        c (first (second v))
        d (second (second v))]
    (and (not (= a b))
         (= a d)
         (= b c))))

(defn amicables [n]
  (let [all (map #(n-with-d %) (range (inc n)))]
    (filter amicable? (for [x all y all] [x y]))))

(defn sum-amicables-to [n]
  (/ (reduce + (flatten (amicables n))) 4))

