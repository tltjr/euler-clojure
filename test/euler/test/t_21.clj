(ns euler.test.t-21
  (:use euler.21
        lazytest.describe))

(describe "The divisors function"
  (it "returns the divisors of 10"
    (= (divisors 10) '(1 2 5)))

  (it "returns the divisors of 12"
    (= (divisors 12) '(1 2 3 4 6))))

(describe "The function 'd'"
  (it "sums the divisors of 10"
    (= (d 10) 8))

  (it "sums the divisors of 100"
    (= (d 100) 117)))

(describe "n-with-d returns n with d(n)"
  (it "returns a vector"
    (= (n-with-d 4) [4 3]))

  (it "works for 100 too"
    (= (n-with-d 100) [100 117])))

(describe "the amicables? pred"
  (it "is false if the elements equal themself (is this true?)"
    (= (amicable? [[0 0] [0 0]]) false)))

(describe "the amicables function"
  (it "finds n, d(n) pairs where d(d(n)) = n" true))
    ;(= (amicables 1000) '([1 2]))))

