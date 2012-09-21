;; Task:
;; Given two strings, work out if they both have exactly the same characters in them.

#(=(sort %)(sort %2))

;; Usage as an anonymous function:
;;
;; (#(=(sort %)(sort %2)) "boat" "boat")
;; => true

;; Hre is a slightly longer alternative that works on arbitrary number of inputs

#(apply =(map sort %&))