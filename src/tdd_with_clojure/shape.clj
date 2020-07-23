(ns tdd-with-clojure.shape
  (:require [clojure.string :as strings])
  (:gen-class))

(defn square
  [side]
  
  (loop [x-cord 0]
    (when (< x-cord side)
      (loop [y-cord 0]
        (when (< y-cord side)
          (if (or (= x-cord 0)
            (= x-cord (- side 1))
            (= y-cord 0)
            (= y-cord (- side 1)))
            (print "*")
            (print " ")
		  )
          (recur (inc y-cord))
          ))
      (println "")
      (recur (inc x-cord))))
  )

(defn diamond
		[width]
		(def diamond_array (vec (repeat width (vec (repeat width " ")))))
  (def mid (quot width 2))
  (if (= (rem width 2) 1)
  					(doseq [row (range 0 (inc mid))
					    						col (range 0 (inc (- width 1)))]
					    							(if (or (= col (- mid row))
					    															(= col (+ mid row)))
					    		 									(def diamond_array (assoc diamond_array row (assoc (get diamond_array row) col "#")))
					    		 					))
  					(doseq [row (range 0 (inc (- mid 1)))
    											col (range 0 (inc (- width 1)))]
    												(if (or (= col (- mid row 1))
    																				(= col (+ mid row)))
    		 													(def diamond_array (assoc diamond_array row (assoc (get diamond_array row) col "#")))
    		 										))
   )
   (if (= (rem width 2) 1)
   				(doseq [row (range (+ mid 1) (inc (- width 1)))
					  								col (range 0 (inc (- width 1)))]
										  				(if (or (= col (- mid (- (- width 1) row)))
										  				        (= col (+ mid (- (- width 1) row))))
										  				  (def diamond_array (assoc diamond_array row (assoc (get diamond_array row) col "#")))
										  				))
   				(doseq [row (range mid  (inc (- width 1)))
					  								col (range 0 (inc (- width 1)))]
										  				(if (or (= col (- mid (- (- width 1) row) 1))
										  				        (= col (+ mid (- (- width 1) row))))
										  				  (def diamond_array (assoc diamond_array row (assoc (get diamond_array row) col "#")))
										  				))
  	)
 		diamond_array
)

(defn triangle
  [side]
  
  (loop [x-cord 0]
    (when (< x-cord side)
      (loop [y-cord 0]
        (when (< y-cord side)
          (if (or (= x-cord y-cord)
                  (= x-cord (- side 1))
                  (= y-cord 0))
            (print "*")
            (print " "))
          (recur (inc y-cord))))
      (println "")
      (recur (inc x-cord))))
  )

(defn combine
		[& args]
		(def max_size 0)
		(doseq [shape (range (count args))]
					(def max_size (max max_size (count (nth args shape)))))
		(def final_array (vec (repeat max_size (vec (repeat max_size " ")))))

		(doseq [each (range (count args))]
				(def array  (nth args each))
				(doseq [row (range (count array))
											col (range (count array))]
						(if (or (= (get (get final_array row) col) "#")
														(= (get (get array row) col) "#")
											)
											(def final_array (assoc final_array row (assoc (get final_array row) col "#")))
											(def final_array (assoc final_array row (assoc (get final_array row) col " ")))  
							)))
		 final_array
)

(defn render
			[final_array]
			(doseq [row (range 0 (inc (- (count final_array) 1)))]
      (println (strings/join "" (get final_array row))))
)

