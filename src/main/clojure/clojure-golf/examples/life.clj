
;; 113 characters - inspired by Christophe Grand's approach:
;; http://clj-me.cgrand.net/2011/08/19/conways-game-of-life/
#(set(for[[p n](frequencies(mapcat(fn[[x y]](for[a[-1 0 1]b[-1 0 1]][(+ a x)(+ b y)]))%)):when({3 1 4(% p)}n)]p))
#(set(for[z[[-1 0 1]][p n](frequencies(mapcat(fn[[x y]](for[a z b z][(+ a x)(+ b y)]))%)):when({3 1 4(% p)}n)]p))

; usage:
; (<<<function>>> #{[1 0] [1 1] [1 2]})