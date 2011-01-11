(defn fac [n]
  (if (= n 1)
    1
    (* n (fac (dec n)))))

(reduce + (map #(Character/getNumericValue %) (flatten (partition 1 (str (fac 100))))))
