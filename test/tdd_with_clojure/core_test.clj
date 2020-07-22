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
