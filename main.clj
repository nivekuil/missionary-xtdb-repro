(ns main
  (:require [xtdb.api :as xt]
            [missionary.core :as y]))

(def test-node (xt/start-node {}))
(->> (xt/submit-tx test-node [[::xt/put {:xt/id {:foo "1"}}]])
     (xt/await-tx test-node))

;; correctly returns the entity
(xt/entity (xt/db test-node) {:foo "1"})

;; returns nil??
(y/? (y/sp (xt/entity (xt/db test-node) {:foo "1"})))

