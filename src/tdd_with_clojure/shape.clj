(ns tdd-with-clojure.shape
  (:require [clojure.string :as strings])
  (:gen-class))

(defn square
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
(defn diamond
		[height]
		(def width (+ (* 2 (quot height 2)) 1))
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
			[final_array]
			(doseq [row (range 0 (inc (- (count final_array) 1)))]
      (println (strings/join "" (get final_array row))))
)

