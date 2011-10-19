(ns twentythree.core
  (:use [clojure.contrib server-socket duck-streams]))

(defn handle-client [in out]
  (binding [*in* (reader in)
            *out* (writer out)]
    (dorun (repeatedly #(println (read-line))))))

(defn -main
  []
  (println "yo")
  (create-server 6666 handle-client))
