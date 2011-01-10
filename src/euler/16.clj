(use 'clojure.contrib.math)
;; for flatten - should be in core now
(use 'clojure.contrib.seq-utils)

(reduce + (map #(Character/getNumericValue %) (flatten (partition 1 (str (expt 2 1000))))))
