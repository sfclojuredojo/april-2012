(ns april-2012.score-test
  (:use april-2012.score)
  (:use midje.sweet))

(fact
 (score-frame []) => 0)

(fact
 (score-frame [0 0]) => 0)

(fact
 (score-frame [3 4]) => 7)

(fact
 (score-frame [11]) => (throws IllegalArgumentException "Invalid frame definition."))

(fact
 (score-frame [1 1 1 1]) => (throws IllegalArgumentException "Invalid frame definition."))

;; strike: When all ten pins are knocked down with the first ball (called a strike and typically rendered as an "X" on a scoresheet), a player is awarded ten points, plus a bonus of whatever is scored with the next two balls. In this way, the points scored for the two balls after the strike are counted twice.
;; Frame 1, ball 1: 10 pins (strike)
;; Frame 2, ball 1: 3 pins
;; Frame 2, ball 2: 6 pins
;; The total score from these throws is:
;; Frame one: 10 + (3 + 6) = 19
;; Frame two: 3 + 6 = 9
;; TOTAL = 28

#_(fact
 (score [[3 4] [5 4]]))

;; Two consecutive strikes are referred to as a "double".
;; A double's pinfall is:
;; Frame 1, ball 1: 10 pins (Strike)
;; Frame 2, ball 1: 10 pins (Strike)
;; Frame 3, ball 1: 9 pins
;; Frame 3, ball 2: 0 pins (recorded as a dash '-' on the scoresheet)
;; The total score from these throws is:
;; Frame one: 10 + (10 + 9) = 29
;; Frame two: 10 + (9 + 0) = 19
;; Frame three: 9 + 0 = 9
;; TOTAL = 57
;; Three strikes bowled consecutively are known as a "turkey" or "triple".
;; A turkey's pinfall is:
;; Frame 1, ball 1: 10 pins (Strike)
;; Frame 2, ball 1: 10 pins (Strike)
;; Frame 3, ball 1: 10 pins (Strike)
;; Frame 4, ball 1: 0 pins (Gutterball)
;; Frame 4, ball 2: 9 pins
;; The total score from these throws is:
;; Frame one: 10 + (10 + 10) = 30
;; Frame two: 10 + (10 + 0) = 20
;; Frame three: 10 + (0 + 9) = 19
;; Frame four: 0 + 9 = 9
;; TOTAL = 78
;; Longer strings of strikes are called by various names, including "-Bagger" (Four Bagger) and "-Pack" (Six Pack) depending on local use, equipment, and exposure to the sport.[22][23] Recently, the event of bowling four consecutive strikes has also been called a "hambone".[24] Six strikes and nine strikes in a row can also be referred to "Wild Turkeys" and "Golden Turkeys" respectively. Any string of strikes starting in the first frame or ending "off the sheet" (where all of a bowler's shots from a certain frame to the end of the game strike) are often referred to as the "front" or "back" strikes, respectively (e.g. the "front nine" for strikes in frames 1–9, or the "back six" for strikes in frames 7, 8, and 9 with a turkey in the tenth). A "perfect game" or 12 strikes in a row is also rarely referred to as the "Thanksgiving Turkey". A "Clean Game" is a game with strikes or spares in every frame (not counting bonus balls).
;; A player who scores multiple strikes in succession would score like so:
;; Frame 1, ball 1: 10 pins (strike)
;; Frame 2, ball 1: 10 pins (strike)
;; Frame 3, ball 1: 4 pins
;; Frame 3, ball 2: 2 pins
;; The score from these throws are:
;; Frame one: 10 + (10 + 4) = 24
;; Frame two: 10 + (4 + 2) = 16
;; Frame three: 4 + 2 = 6
;; TOTAL = 46
;;
