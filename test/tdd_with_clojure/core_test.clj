(ns tdd-with-clojure.core-test
  (:require [clojure.test :refer :all]
            [tdd-with-clojure.core :refer :all]))

(deftest test-square
  (testing "Matches correct generation of vectors for square of 5 units"
    (def square_array (vec (tdd-with-clojure.shape/square 5)))
    (is (= (get square_array 0) ["#" "#" "#" "#" "#"]))
    (is (= (get square_array 1) ["#" " " " " " " "#"]))
    (is (= (get square_array 2) ["#" " " " " " " "#"]))
    (is (= (get square_array 3) ["#" " " " " " " "#"]))
    (is (= (get square_array 4) ["#" "#" "#" "#" "#"]))))


(deftest test-diamond
  (testing "Matches correct generation of vectors for diamond of 3 units"
    (def diamond_array (vec (tdd-with-clojure.shape/diamond 3)))
    (is (= (get diamond_array 0) [" " "#" " "]))
    (is (= (get diamond_array 1) ["#" " " "#"]))
    (is (= (get diamond_array 2) [" " "#" " "]))))

(deftest test-triangle
  (testing "Matches correct generation of vectors for triangle of 4 units"
    (def triangle_array (vec (tdd-with-clojure.shape/triangle 4)))
    (is (= (get triangle_array 0) ["#" " " " " " "]))
    (is (= (get triangle_array 1) ["#" "#" " " " "]))
    (is (= (get triangle_array 2) ["#" " " "#" " "]))
    (is (= (get triangle_array 3) ["#" "#" "#" "#"]))))

(deftest test-combine
  (testing "Matches correct generation of vectors for combination of 2 shapes"
    (def combine_array (vec (tdd-with-clojure.shape/combine "square 5 square 3")))
    (is (= (get combine_array 0) ["#" "#" "#" "#" "#"]))
    (is (= (get combine_array 1) ["#" " " "#" " " "#"]))
    (is (= (get combine_array 2) ["#" "#" "#" " " "#"]))
    (is (= (get combine_array 3) ["#" " " " " " " "#"]))
    (is (= (get combine_array 4) ["#" "#" "#" "#" "#"]))))
