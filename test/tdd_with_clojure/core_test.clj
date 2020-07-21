(ns tdd-with-clojure.core-test
  (:require [clojure.test :refer :all]
            [tdd-with-clojure.core :refer :all]))

(deftest test-square
  (testing "Matches correct generation of vectors for square of 5 units"
    (def square (vec (tdd-with-clojure.shape/generate_square 5)))
    (is (= (get square 0) ["#" "#" "#" "#" "#"] ))
    (is (= (get square 1) ["#" " " " " " " "#"]))
    (is (= (get square 2) ["#" " " " " " " "#"]))
    (is (= (get square 3) ["#" " " " " " " "#"]))
    (is (= (get square 4) ["#" "#" "#" "#" "#"]))))
