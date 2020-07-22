(ns tdd-with-clojure.core
  (:require [tdd-with-clojure.shape :as print_shapes])
  (:gen-class))


(defn -main
  [& args]
  (let [user_input (read-line)]
    (print_shapes/render user_input))
)
