(ns clojure-golf.tricks)

;; spaces around all types of parentheses and delimiters can be removed
(for [i (range 10)] {:key i :value "foo"})
(for[i(range 10)]{:key i :value"foo"})

;; adding a single-element vector to a for loop can be shorter than a let
(for [i (range 10)] [(str "A long-string needed twice" i) "A long-string needed twice"])
(for [i (range 10)] (let [s "A long-string needed twice"] [(str s i) s]))
(for [i (range 10) s ["A long-string needed twice"]] [(str s i) s])

;; if they are goimg to be converted to strings, using symbols can be shorter than quoted text
(map #(str "foo" %) ["A" "B" "C"])
(map #(str "foo" %) ['A 'B 'C])

;; map is shorter than for in some cases
(for[i(range 10)](* i i))
(map #(* % %)(range 10))

;; #(do%) is shorter than identity
(partition-by identity [1 1 1 2 3 3 3 3 6 6 6 6])
(partition-by #(do%) [1 1 1 2 3 3 3 3 6 6 6 6])

;; default values on map gets can be very handy
(map #(if (= 0 (mod % 3)) "Fizz" %) (range 10))
(map #({0 "Fizz"} (mod % 3) %) (range 10))

;; hashmaps are equivalent to and shorter than sequences of pairs when used as a sequence
(seq [["A"1]["B"2]["C"3]])
(seq {"A"1"B"2"C"3})

;; strings can often be used directly as a sequence of characters, without needing "seq"
(reverse (seq "Abracadabra"))
(reverse "Abracadabra")

;; strings used together with maps are useful to generate longer sequences
(let[a "Eggs"b"Jelly"c"Toast"][a b c a a b b c c a a a b b b c c c])
(map{\a"Eggs"\b"Jelly"\c"Toast"}"abcaabbccaaabbbccc")

;; if you use a function repeatedly, it is often better to alias it
(for [i (range 100)] [(mod i 3) (mod i 5) (mod i 7) (mod i 9)])
(for [i (range 100)m[mod]] [(m i 3) (m i 5) (m i 7) (m i 9)])
(for [i (range 100)m[#(mod i %)]] [(m 3) (m 5) (m 7) (m 9)])

;; set literals are useful for filtering
(filter #(= "Foo" %) ["Foo" "Bar" "Baz"])
(filter #{"Foo"} ["Foo" "Bar" "Baz"])

;; scientific notation can shorten certain common large constants
1000000
1E6

;; you can still use % in ananoymous function with multiple arguments
;; in addition, spaces can be removed
(#(str %1 %3 %2) "A" "B" "C")
(#(str%%3%2) "A" "B" "C")

;; apply can be shorter than reduce
(reduce + (range 1000))
(apply + (range 1000))


