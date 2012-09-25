;; Task:  generate a random 18-hole golf course.
;; 
;; must have 18 holes
;; hole lengths must add up to 72
;; all possible configurations must be generated with non-zero probability


;; First version - 72 Chars
(some #(if(=(apply +%)72)%)(partition 18(repeatedly #(+(rand-int 3)3))))