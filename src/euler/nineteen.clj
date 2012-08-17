(ns euler.nineteen
    (:use clj-time.core))

;; Better implementation from rosettacode.org/wiki/Leap_year#Clojure
(defn leap? [y]
  (and (zero? (mod y 4)) (or (pos? (mod y 100)) (zero? (mod y 400)))))

(def month-offsets (hash-map 1 0, 2 31, 3 59, 4 90, 5 120, 6 151, 7 181, 8 212, 9 243, 10 273, 11 304, 12 334))

(defn month-offset [month year]
  (if (and (leap? year) (> month 2))
    (+ 1 (get month-offsets month))
    (get month-offsets month)))

(defn absolute-day [datetime]
  (let [y (int (year datetime))]
    (int (+ (* (- y 1900)
            365)
         (month-offset (month datetime) y) 
         (day datetime)))))

(defn sunday? [d]
  (zero? (mod d 7)))

(def answer (count (filter sunday? (range (absolute-day (date-time 1900 1 1)) (absolute-day (date-time 2000 12 31))))))
