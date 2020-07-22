(ns tdd-with-clojure.shape
  (:require [clojure.string :as strings])
  (:gen-class))

(defn generate_square
  [side]
  (def square_array (vec (repeat side (vec (repeat side " ")))))
  
  (doseq [row (range 0 (inc (- side 1)))
          col (range 0 (inc (- side 1)))]
    (if (or (= row 0)
            (= row (- side 1))
            (= col 0)
            (= col (- side 1)))
      (def square_array (assoc square_array row (assoc (get square_array row) col "#")))
      )
    )
  square_array
  )

(defn render
  [user_input]
  
  (def function_name (get (strings/split user_input #" ") 0))
  (def side_width (Integer.(get (strings/split user_input #" ") 1)))
  
  ((def square_array (vec (generate_square side_width)))
    (doseq [row (range 0 (inc (- side_width 1)))]
      (println (strings/join "" (get square_array row))))
  )
)
