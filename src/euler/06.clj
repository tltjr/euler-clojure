(use 'clojure.contrib.math)

(defn square [n]
  (expt n 2))

(defn sumofsquares [a]
  (reduce + (map square a)))

(defn squareofsum [a]
  (square (reduce + a)))

(defn euler6 [n]
  (- (squareofsum (range 1 (inc n)))
     (sumofsquares (range 1 (inc n)))))
