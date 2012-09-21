;; Play the famous "FizzBuzz" game for the first 100 numbers

(for[n(range 1 101)t[(mod n 3)]z[{0"Fizz"}]]({0(str(z t)'Buzz)}(mod n 5)(z t n)))