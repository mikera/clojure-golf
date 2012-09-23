(ns clojure-golf.tricks
  "Assorted tips and tricks for Clojure code golf")

;; ===============================================
;; General / basic tricks

;; whitespace is optional in clojure unless needed to delimit symbols
;; spaces around all types of parentheses etc. can be removed
(for [i (range 10)] {:key i :value "foo"})
(for[i(range 10)]{:key i :value"foo"})

;; ===============================================
;; Strings

;; strings can often be used directly as a sequence of characters
;; - without needing "seq"
(reverse (seq "Abracadabra"))
(reverse "Abracadabra")

;; strings used with maps are useful to generate long sequences
(let[a "Eggs"b"Jelly"c"Toast"][a b c a a b b c c a a a b b b c c c])
(map{\a"Eggs"\b"Jelly"\c"Toast"}"abcaabbccaaabbbccc")

;; ==============================================
;; Anonymous functions

;; you can still use % in ananoymous function with multiple arguments
(#(str %1 %3 %2) "A" "B" "C")
(#(str % %3 %2) "A" "B" "C")

;; furthermore, spaces can be removed from ananoymous functions
(#(str % %3 %2) "A" "B" "C")
(#(str%%3%2) "A" "B" "C")

;; map with an anonymous function is shorter than for in many cases
(for[i(range 10)](* i i))
(map #(*%%)(range 10))

;; ======================================================
;; Literals and constants

;; scientific notation can shorten certain common large constants
1000000
1E6

;; set literals are useful for filtering
(filter #(= "Foo" %) ["Foo" "Bar" "Baz"])
(filter #{"Foo"} ["Foo" "Bar" "Baz"])

;; hashmaps are equivalent to and shorter than sequences of pairs 
;; when used as a sequence
(seq [["A"1]["B"2]["C"3]])
(seq {"A"1"B"2"C"3})


;; ======================================================
;; Better versions of common functions

;; apply can be shorter than reduce
(reduce + (range 1000))
(apply + (range 1000))

;; #(do%) is shorter than identity and comp is even shorter
(partition-by identity [1 1 1 2 3 3 3 3 6 6 6 6])
(partition-by #(do%) [1 1 1 2 3 3 3 3 6 6 6 6])
(partition-by comp [1 1 1 2 3 3 3 3 6 6 6 6])

;; indexed access on vectors is shorter than first (or second etc..)
(first [:a :b]) 
([:a :b] 0) 

;; ======================================================
;; Unusual functions good for golfing

;; frequencies is a long function name, but is surprisingly useful
;; e.g. getting the most common character in a string
((last(sort-by second(frequencies "abracadabra")))0)

;; ======================================================
;; Advanced tricks

;; adding a single-element vector to a for loop can be shorter
;; when compared to repeating a literal or a let
(for [i (range 10)] [(str "A long-string needed twice" i) "A long-string needed twice"])
(for [i (range 10)] (let [s "A long-string needed twice"] [(str s i) s]))
(for [i (range 10) s ["A long-string needed twice"]] [(str s i) s])

;; if they are goimg to be converted to strings, using symbols 
;; can be shorter than quoted text
(map #(str "foo" %) ["A" "B" "C"])
(map #(str "foo" %) ['A 'B 'C])

;; if you use a function repeatedly, it may be better to alias it
(for [i (range 100)] [(mod i 3) (mod i 5) (mod i 7) (mod i 9)])
(for [i (range 100)m[mod]] [(m i 3) (m i 5) (m i 7) (m i 9)])
(for [i (range 100)m[#(mod i %)]] [(m 3) (m 5) (m 7) (m 9)])

;; default values on map gets can be very handy
(map #(if (= 0 (mod % 3)) "Fizz" %) (range 10))
(map #({0 "Fizz"} (mod % 3) %) (range 10))





