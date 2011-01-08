(use 'clojure.contrib.math)
(use 'clojure.contrib.seq-utils)

(def pairs (for [a (range 333) b (range 500)] (list a b))) 

(defn calc-c [ab]
  (sqrt (+ (expt (first ab) 2)
           (expt (second ab) 2))))

(defn sum-pyth [ab]
  (+ (first ab)
     (second ab)
     (calc-c ab)))

(defn euler9 []
  (let [ab (find-first (fn [ab] (= (sum-pyth ab) 1000)) pairs)]
    (* (first ab)
       (second ab)
       (calc-c ab))))
