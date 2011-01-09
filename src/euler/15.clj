(use 'clojure.contrib.math)

(defn fac [n]
  (loop [m n acc 1]
    (if (= m 1)
      acc
      (recur (dec m) (* acc m)))))

(/ (fac 40) (expt (fac 20) 2))

