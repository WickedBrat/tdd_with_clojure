(ns tdd-with-clojure.shape
  (:require [clojure.string :as strings])
  (:gen-class))

(defn square
  ([side] (square 0 0 (- side 1) []))
  ([x-cord y-cord side square_array]
   (let [x (concat [] (if (<= x-cord side)
                        (if (= y-cord side)
                          ["#"]
                          (let [temp_array
                                (if (or (= x-cord 0)
                                        (= x-cord side)
                                        (= y-cord 0))
                                  (concat ["#"] (square x-cord (inc y-cord) side square_array))
                                  (concat [" "] (square x-cord (inc y-cord) side square_array)))]
                            (if (= (count temp_array) (+ side 1))
                              (square (inc x-cord) 0 side (concat square_array temp_array))
                              temp_array)))
                        square_array))] x)))


(defn diamond
   ([width] (diamond 0 0 (quot width 2) width []))
   ([x-cord y-cord mid width diamond_array]
    (let [x (concat [] (if (= (rem width 2) 1)
                           (if (<= x-cord mid)
                               (if (< y-cord width)
                                   (if (or (= y-cord (- mid x-cord))
                                           (= y-cord (+ mid x-cord)))
                                       (concat ["#"] (diamond x-cord (inc y-cord) mid width diamond_array))
                                       (concat [" "] (diamond x-cord (inc y-cord) mid width diamond_array )))
                                (diamond (inc x-cord) 0 mid width diamond_array))
                               (if (< x-cord width)
                                   (if (< y-cord width)
                                       (if (or (= y-cord (- mid (- (- width 1) x-cord)))
                                               (= y-cord (+ mid (- (- width 1) x-cord))))
                                           (concat ["#"] (diamond x-cord (inc y-cord) mid width diamond_array))
                                           (concat [" "] (diamond x-cord (inc y-cord) mid width diamond_array )))
                                 (diamond (inc x-cord) 0 mid width diamond_array))
                                 diamond_array))


                           (if (< x-cord mid)
                               (if (< y-cord width)
                                   (if (or (= y-cord (- mid x-cord 1))
                                           (= y-cord (+ mid x-cord)))
                                       (concat ["#"] (diamond x-cord (inc y-cord) mid width diamond_array))
                                       (concat [" "] (diamond x-cord (inc y-cord) mid width diamond_array )))
                                (diamond (inc x-cord) 0 mid width diamond_array))
                               (if (< x-cord width)
                                   (if (< y-cord width)
                                       (if (or (= y-cord (- mid (- (- width 1) x-cord) 1))
                                               (= y-cord (+ mid (- (- width 1) x-cord))))
                                           (concat ["#"] (diamond x-cord (inc y-cord) mid width diamond_array))
                                           (concat [" "] (diamond x-cord (inc y-cord) mid width diamond_array )))
                                 (diamond (inc x-cord) 0 mid width diamond_array))
                                 diamond_array))))] x ))) 


(defn triangle
  ([side] (triangle 0 0 (- side 1) []))
  ([x-cord y-cord side triangle_array]
   (let [x (concat [] (if (<= x-cord side)
                        (if (= y-cord side)
                          (if (= x-cord side)
                            ["#"]
                            [" "])
                          (let [temp_array
                                (if (or (= x-cord y-cord)
                                        (= x-cord side)
                                        (= y-cord 0))
                                  (concat ["#"] (triangle x-cord (inc y-cord) side triangle_array))
                                  (concat [" "] (triangle x-cord (inc y-cord) side triangle_array)))]
                            (if (= (count temp_array) (+ side 1))
                              (triangle (inc x-cord) 0 side (concat triangle_array temp_array))
                              temp_array)))
                        triangle_array))] x)))

(defn combine
  [& args]

  (let [max-size (apply max (let [lengths (map count args)] lengths))]
    ((def final_array (vec (repeat max-size " ")))
     (loop [array_index 0]
       (when (< array_index (count args))
         (loop [index 0]
           (when (< index (count (nth args array_index)))
             (if (= (nth (nth args array_index) index) "#")
               (assoc final_array index "#"))
             (recur (inc index))))
         (recur (inc array_index))))
     )
    final_array))

(defn print-array
  [array, width]
  
  (doseq [[index character] (map-indexed vector array)]
    (if (= (mod (+ index 1) width) 0)
      (println character)
      (print character))))

(defn render
   [final_array]
   (doseq [row (range 0 (inc (- (count final_array) 1)))]
      (println (strings/join "" (get final_array row))))
)

