(ns tic-tac-toe.core
  (:require [clojure.string :as str]))

(def board-length 3)

(defn init-board []
  (->>
   (repeat 9 " ")
   (partition 3)
   (map vec)
   vec))

;; (defn init-board []
;;   [["X" "0" " "] [" " "X" "O"] ["O" " " "X"]])

(defn get-cell [board x y]
  (nth (nth board x) y))

(defn print-div [row-length]
  (println (str/join "" (repeat row-length "-----"))))

(defn print-row [board row-number]
  (print "| ")
  (dotimes [n board-length]
    (print (get-cell board row-number n) " | "))
  (println))

(defn move [board x y value]
  (assoc-in board [x y] value))

(defn print-board [board]
  (print-div board-length)
  (dotimes [n board-length]
    (print-row board n)
    (print-div board-length)))

(defn user-move []
  ())

(defn game []
  (let [board (init-board)]
    (print-board board)))

(game)
