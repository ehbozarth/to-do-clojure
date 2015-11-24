(ns to-do-clojure.core
  (:gen-class))
;This is where the main funciton is

;Create To-Do's in A Vector
;atom makes it mutable
(def to-dos (atom []))


;seperate function (add to do item with "input" as the argument
;Read from input and store in atom
(defn add-to-do [input]
  (reset! to-dos (conj (deref to-dos) input))                                                 ;end of reset
  );end of add-to-do


;Main method
(defn -main [& args]
    (println "Type a to-do and hit enter.")
    (loop []                                                ;begin loop
      (let [input (read-line)]                              ;begin let
        (when (not= input "q")                             ;begin when
          (add-to-do input)                                 ;call add-to-do method
          (recur)                                           ;recur to keep loop continue
          )                                                 ;end of when
        )                                                   ;end of let
      )                                                     ;end of loop
    (println (deref to-dos))
  );end of main
