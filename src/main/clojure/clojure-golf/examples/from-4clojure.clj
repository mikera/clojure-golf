

;; Problem 115 - The Balance of N

;; A balanced number is one whose component digits have the same sum on the left and right halves of the number. Write a function which accepts an integer n, and returns true iff n is balanced.

;; v1 - 86 characters
#(let[s(map int(str%))r(reverse s)z(fn[x](apply +(take(/(count x)2)x)))](=(z r)(z s)))

;; v2 - 74 characters
(comp #(= 0(apply +(apply map -(split-at(/(count%)2)%))))#(map int(str%)))

;; v3 - 74 characters
#(let[s(map int(str%))a apply](= 0(a +(a map -(split-at(/(count s)2)s)))))