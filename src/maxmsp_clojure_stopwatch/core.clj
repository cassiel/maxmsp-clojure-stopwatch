(ns maxmsp-clojure-stopwatch.core
  (:gen-class
   :name clojure.Stopwatch
   :prefix max-
   :extends com.cycling74.max.MaxObject
   :state lastsample
   :init init)
  (:import (com.cycling74.max Atom)))

(defn max-init []
  [[] (atom nil)])

(defn- interval! [state]
  "Update a state to current time, return interval from last state."
  (let [now (System/currentTimeMillis)
        oldState @state]
    (do
      (swap! state (fn [_] now))
      (if oldState
        (- now oldState)
        0))))

(defn max-bang [this]
  "Output time in msec since last bang, or 0 if this is the first bang."
  (.outlet this 0 (interval! (.lastsample this))))
