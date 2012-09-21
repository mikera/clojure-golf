(ns clojure-golf.rickroll.rickroll
  (:import mikera.util.Resource))

(def rr
(let [r{\&" and "\Y"You"\0"\n"\1" you"\2" gonna"\3"give"\5" up"\6"ever"\F" how I'm feeling"\T" to"}
      s str 
      n"0N62 "
      c(s n"315"n"let1 down"n"run around&desert1"n"make1 cry"n"say goodbye"n"tell a lie&hurt10")
      p"0(Ooh, 315)"
      g"0(Give15)"
      q(s n "3, n62 3")
      o"0(Ooh)"
      w(s "0We've known each other for so long0Yr heart's been aching but0Y'reTo shyT say it0Inside we both know what's been going on0We know the game&we're2 play it0")
      u(s "I just wanna tell1F0Gotta make1 understand0")
      v"We're no strangersT love0Y know the rules&so do I0A full commitment's what I'm thinking of0Y wouldn't get this from any other guy0"
      R(s v u c w"And if1 ask meF0Don't tell me1'reTo blindT see0"c c p p o q g o q g\0 w\0 u c c c)]
  (apply s(map #(r% %)R)))                                                
)

(def txt (Resource/getResourceAsString "clojure-golf/rickroll/rickroll.txt"))

(defn test [] (= rr txt)) 

