(defproject cljs-websockets-async "0.1.0-SNAPSHOT"
  :description "ClojureScript core.async wrapper around WebSocket to communicate via EDN"
  :url "https://github.com/loganlinn/cljs-websockets-async"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/clojurescript "0.0-1859"]
                 [org.clojure/core.async "0.1.0-SNAPSHOT"]]
  :repositories {"sonatype-oss-public" "https://oss.sonatype.org/content/groups/public/"}

  :plugins [[lein-cljsbuild "0.3.2"]]
  :cljsbuild  {:builds [{:source-paths ["src"]
                         :compiler {:optimizations :whitespace
                                    :pretty-print true
                                    :output-to "out/websocket.js"}}]})
