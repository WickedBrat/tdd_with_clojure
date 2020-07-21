(ns tdd-with-clojure.core
  (:require [clojure.string :as strings])
  (:gen-class))

(defn print_square
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
  (doseq [row (range 0 (inc (- side 1)))]
    (println (strings/join "" (get square row)))
  )
)


(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (print_square 5)
)

