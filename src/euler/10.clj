(use 'clojure.contrib.lazy-seqs)

(reduce + (take-while #(< % 2000000) primes))

