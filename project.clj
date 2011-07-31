(defproject maxmsp-clojure-stopwatch "1.0.0"
  :description "A stopwatch for MaxMSP written in Clojure"
  :dependencies [[org.clojure/clojure "1.2.1"]
                 [com.cycling74/com-cycling74-max "5.1.9"]]
  :aot [maxmsp-clojure-stopwatch.core])