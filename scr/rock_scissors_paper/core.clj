(ns rock-scissors-paper.core
  (:require [clojure.string :as str]))

(defn moves []
  '(:rock :paper :scissors))

(def winning
  {:rock :scissors 
   :scissors :paper 
   :paper :rock})

(defn computer-move []
  (let [move (rand-nth (moves))]
    (println "Computer move: " move)
    move))

(defn move-match [move]
  (case (str/upper-case move)
    "R" :rock
    "P" :paper
    "S" :scissors
    nil))

(defn player-move []
  (println "R for rock, P for paper, S for scissors")
  (let [move (move-match (clojure.core/read-line))]
    (if move
      move
      (do
        (println "Invalid move")
        (recur)))))

(defn win [player-move computer-move]
  (cond
    (= player-move computer-move) :draw
    (= (winning player-move) computer-move) :win
    :else :lose))

(defn game []
  (let [p-move (player-move)
        c-move (computer-move)
        result (win p-move c-move)]
    (println "You played " p-move ", computer played " c-move ", you " result)))

(game)
