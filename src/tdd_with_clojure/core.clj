(ns tdd-with-clojure.core
  (:require [tdd-with-clojure.shape :as print_shapes])
  (:gen-class))


(defn -main
  [& args]
  (print_shapes/square "5")
)
