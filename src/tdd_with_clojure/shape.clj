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
(defn generate_diamond
		[width]
		(def diamond_array (vec (repeat width (vec (repeat width " ")))))
  (def mid (quot width 2))
  (doseq [row (range 0 (inc mid))
    						col (range 0 (inc (- width 1)))]
    	(if (or (= col (- mid row))
    									(= col (+ mid row)))
    		 (def diamond_array (assoc diamond_array row (assoc (get diamond_array row) col "#")))
    		 )
   )
  (doseq [row (range (+ mid 1) (inc (- width 1)))
  								col (range 0 (inc (- width 1)))]
  				(if (or (= col (- mid (- (- width 1) row)))
  				        (= col (+ mid (- (- width 1) row))))
  				  (def diamond_array (assoc diamond_array row (assoc (get diamond_array row) col "#")))
  				)
  )
  diamond_array
)

(defn render
  [user_input]
  
  (def function_name (get (strings/split user_input #" ") 0))
  (def side_width (Integer.(get (strings/split user_input #" ") 1)))
  (if (= function_name "square")
  ((def square_array (vec (generate_square side_width)))
    (doseq [row (range 0 (inc (- side_width 1)))]
      (println (strings/join "" (get square_array row))))
  ))

  (if (= function_name "diamond")
  ((def diamond_array (vec (generate_diamond side_width)))
    (doseq [row (range 0 (inc (- side_width 1)))]
      (println (strings/join "" (get diamond_array row))))
  ))


)
