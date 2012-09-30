;; Task:  generate a random 18-hole golf course.
;; 
;; must have 18 holes
;; hole lengths must add up to 72
;; all possible configurations must be generated with non-zero probability


;; First version - 72 Chars
(some #(if(=(apply +%)72)%)(partition 18(repeatedly #(+(rand-int 3)3))))

;; Fun version - 64 chars
(shuffle(take 18(concat(repeat(*(rand-int 9)2)4)(cycle [3 5]))))

;; Ultra version - 55 chars
(shuffle(mapcat #([[4 4][3 5]%](rand-int 2))(range 9)))