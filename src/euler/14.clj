;; There has to be a better way, but I couldn't find it
(defn append [n coll]
  (reverse (cons n (reverse coll))))

(defn transform [n]
  (if (even? n)
    (/ n 2)
    (+ (* n 3) 1)))

(defn itseq [n]
  (loop [n 0 coll '()]
    (if (= n 1)
      (append n coll)
      (recur (transform n) (append n coll)))))

;; (defn itseq [n]
;;   (defn rec [n coll]
;;     (if (= n 1)
;;       (append n coll)
;;       (recur (transform n) (append n coll))))
;;   (rec n '()))

;; (defn max-itseq [outer-coll]
;;   (defn rec [outer-coll mx n]
;;     (if (empty? outer-coll)
;;       n
;;       (let [inner-coll (first outer-coll)]
;;         (if (> (count inner-coll) mx)
;;           (rec (rest outer-coll) (count inner-coll) (first inner-coll))
;;           (rec (rest outer-coll) mx n)))))
;;   (rec outer-coll 0 0))

(defn max-itseq [outer-coll]
  (defn rec [outer-coll mx n]
    (if (empty? outer-coll)
      n
      (let [inner-coll (first outer-coll)]
        (if (> (count inner-coll) mx)
          (recur (rest outer-coll) (count inner-coll) (first inner-coll))
          (recur (rest outer-coll) mx n)))))
  (rec outer-coll 0 0))
