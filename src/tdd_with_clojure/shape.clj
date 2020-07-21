(ns tdd-with-clojure.shape
  (:require [clojure.string :as strings])
  (:gen-class))

(defn generate_square
  [side]
  (def square (vec (repeat side (vec (repeat side " ")))))
  
  (doseq [row (range 0 (inc (- side 1)))
          col (range 0 (inc (- side 1)))]
    (if (or (= row 0)
            (= row (- side 1))
            (= col 0)
            (= col (- side 1)))
      (def square (assoc square row (assoc (get square row) col "#")))
    )
  )
  square
)

(defn square
  [side_width]
  (def square (vec (generate_square side_width)))
  
  (doseq [row (range 0 (inc (- side_width 1)))]
    (println (strings/join "" (get square row))))
)
