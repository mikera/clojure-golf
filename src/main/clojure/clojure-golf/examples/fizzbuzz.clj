;; Play the famous "FizzBuzz" game for the first 100 numbers

;; v1 - 81 charcaters
(for[n(range 1 101)t[(mod n 3)]z[{0"Fizz"}]]({0(str(z t)'Buzz)}(mod n 5)(z t n)))

;; v2 - 80 characters
(map #(let[t(mod% 3)z{0"Fizz"}]({0(str(z t)'Buzz)}(mod% 5)(z t%)))(range 1 101))