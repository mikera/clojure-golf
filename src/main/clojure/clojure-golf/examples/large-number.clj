;; Find a way to output a large integer with few characters. 
;; Solutions will be scored based on the magnitude of the number and shortness of code.

(nth(iterate #(expt % %)X)Y)

;; Strategy is to repeatedly apply the function f(x)=x^x. 
;; Works fine because Clojure automatically uses BigInteger arthmetic 
;; when this starts to overflow the normal integer range

;; you need to provide values of X and Y.
;; this quickly gets ridiculously large
;; e.g. X=2, Y=3 gives about 3.2*10^619