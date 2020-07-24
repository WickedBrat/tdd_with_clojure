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
  (let [mid (quot width 2)]
    (if (= (rem width 2) 1)
      (loop [x-cord 0]
        (when (< x-cord (inc mid))
          (loop [y-cord 0]
            (when (< y-cord width)
              (if (or (= y-cord (- mid x-cord))
                      (= y-cord (+ mid x-cord)))
                (print "*")
                (print " "))
              (recur (inc y-cord))))
          (println "")
          (recur (inc x-cord))))

      (loop [x-cord 0]
        (when (< x-cord (inc (- mid 1)))
          (loop [y-cord 0]
            (when (< y-cord width)
              (if (or (= y-cord (- mid x-cord 1))
                      (= y-cord (+ mid x-cord)))
                (print "*")
                (print " "))
              (recur (inc y-cord))))
          (println "")
          (recur (inc x-cord)))))

    (if (= (rem width 2) 1)
      (loop [x-cord (+ mid 1)]
        (when (< x-cord width)
          (loop [y-cord 0]
            (when (< y-cord width)
              (if (or (= y-cord (- mid (- (- width 1) x-cord)))
                      (= y-cord (+ mid (- (- width 1) x-cord))))
                (print "*")
                (print " "))
              (recur (inc y-cord))))
          (println "")
          (recur (inc x-cord))))

      (loop [x-cord mid]
        (when (< x-cord  width)
          (loop [y-cord 0]
            (when (< y-cord width)
            		; (print x-cord y-cord)
              (if (or (= y-cord (- mid (- (- width 1) x-cord) 1))
                      (= y-cord (+ mid (- (- width 1) x-cord))))
                (print "*")
                (print " "))
              (recur (inc y-cord))))
          (println "")
          (recur (inc x-cord))))))
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

