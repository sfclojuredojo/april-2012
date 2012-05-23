(ns april-2012.score)

(defn valid-frame? [frame]
  (or
   (not-any? (fn [x] (or (< x 0)
                        (> x 10)))
             frame)
   (> (count frame) 2)))

(defn score-frame [frame]
  (if (not (valid-frame? frame))
    (throw (IllegalArgumentException. "Invalid frame definition.")))
  (reduce + frame))