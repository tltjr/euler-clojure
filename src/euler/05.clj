(use 'clojure.contrib.math)

(defn euler5 [n]
  (reduce lcm (range 1 (inc n))))
