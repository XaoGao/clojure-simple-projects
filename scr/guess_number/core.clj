(ns guess-number.core)

(defn computer-generate-number []
  (rand-int 101))

(defn check-number [computer-number user-guess]
  (cond
    (= computer-number user-guess) :win
    (> computer-number user-guess) :low
    :else :high))

(defn user-guess-number []
  (println "Guess a number between 0 and 100: ")
  (let [input (clojure.core/read-line)]
    (try
      (let [num (Integer/parseInt input)]
        (if (and (<= 0 num) (<= num 100))
          num
          (do
            (println "Invalid input. Please enter a number between 0 and 100.")
            (user-guess-number))))
      (catch Exception _
        (println "Invalid input. Please enter a number.")
        (user-guess-number)))))

(defn engine [computer-number]
  (loop []
    (let [user-guess (user-guess-number)]
      (case (check-number computer-number user-guess)
        :win (println "You win!")
        :low (do (println "Too low! Try again.") (recur))
        :high (do (println "Too high! Try again.") (recur))))))

(defn game []
  (engine (computer-generate-number)))

(game)
