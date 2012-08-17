(ns euler.test.t-19
    (:use euler.nineteen
          [lazytest.describe :only (describe it testing)]
          clj-time.core))

(describe "nineteen"
  (testing "The leap? function"
            (it "returns false if not divisible by 4"
                (not (leap? 5)))
            (it "returns true if divisible by 4"
                (leap? 4))
            (it "returns false if divisible by 100"
                (not (leap? 100)))
            (it "returns true if divisible by 400"
                (leap? 400)))

  (testing "The month-offset function"
           (it "returns 0 for 1 (January)"
               (= 0 (month-offset 1 2011)))
           (it "returns 31 for 2 (February)"
               (= 31 (month-offset 2 2011)))
           (it "returns 59 for 3 (March)"
               (= 59 (month-offset 3 2011)))
           (it "returns 334 for 12 (December)"
               (= 334 (month-offset 12 2011)))
           (it "returns 0 for 1 (January) on leap year"
               (= 0 (month-offset 1 2012)))
           (it "returns 31 for 2 (February) on leap year"
               (= 31 (month-offset 2 2012)))
           (it "returns 60 for 3 (March) on leap year"
               (= 60 (month-offset 3 2012)))
           (it "returns 335 for 12 (December) on leap year"
               (= 335 (month-offset 12 2012)))
           )

  (testing "The absolute-day function"
            (it "returns 1 for 1 Jan 1900"
                (= 1 (absolute-day (date-time 1900 1 1))))
            (it "returns 2 for 2 Jan 1900"
                (= 2 (absolute-day (date-time 1900 1 2))))
            (it "returns 32 for 1 Feb 1900"
                (= 32 (absolute-day (date-time 1900 2 1))))
            (it "returns 366 for 1 Jan 1901"
                (= 366 (absolute-day (date-time 1901 1 1))))
            )

  (testing "The sunday? function"
           (it "returns false for 1 Jan 1900"
               (not (sunday? 1)))
           (it "returns true for 7 Jan 1900"
               (sunday? 7))
  )
)
