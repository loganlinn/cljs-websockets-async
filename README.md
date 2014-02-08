# cljs-websockets-async

A simple [clojure/core.async](https://github.com/clojure/core.async) wrapper
around browser WebSocket that communicates via [EDN](https://github.com/edn-format/edn).

```
channel out  >>(   pr-str    )>> WebSocket send
channel in   <<( read-string )<< WebSocket onmessage
```

## Install

Add to your `project.clj`:

```clojure
[cljs-websockets-async "0.1.0-SNAPSHOT"]
```

## Usage

`cljs-websockets-async.core/connect!` ([source](src/cljs_websockets_async/core.cljs))
returns a channel that passes a value once
the WebSocket connection has been established.

Example:

```clojure
(ns cljs-websockets-async.example
  (:require [cljs-websockets-async.core :as websocket]
            [cljs.core.async :as async :refer [<! >!]])
  (:require-macros [cljs.core.async.macros :refer [go]]))


;; Open Websocket to server; receive map of chans once connected.

(go
  (let [websock (<! (websocket/connect! "ws://localhost:8080"))]
    (loop []
      (when-let [vs (<! (:in websock))]   ;; Read values
        (>! (:out websock) (map inc vs))  ;; Increment & send back
        (recur)))))
```

## See Also

[lynaghk/jetty7-websockets-async](https://github.com/lynaghk/jetty7-websockets-async)
provides a similar library for jetty7.

## License

Copyright © 2013 Logan Linn

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
