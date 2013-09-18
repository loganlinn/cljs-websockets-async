# cljs-websockets-async

A simple [clojure/core.async](https://github.com/clojure/core.async) wrapper
around browser WebSocket that communicates via [EDN](https://github.com/edn-format/edn).

```
channel out  === pr-str ======> WebSocket send
channel in   <== read-string == WebSocket onmessage
```

## Usage


`cljs-websockets-async.core/connect!` ([source](src/cljs_websockets_async/core.cljs))
returns a channel that passes a value once
the WebSocket connection has been established.

Example:

```clojure
(ns cljs-websockets-async
  (:require [cljs-websockets-async.core :as websocket]
            [cljs.core.async :as async :refer [<! >!]])
  (:require-macros [cljs.core.async.macros :refer [go]]))

;; Connect to websocket
;; Continuously recieve a sequence of values from WebSocket
;; Increment values and send back over WebSocket

(go
  (let [{:keys [in out]} (<! (websocket/connect! "ws://localhost:8080"))]
    (loop []
      (when-let [data (<! in)]
        (>! out (map inc data))
        (recur)))))
```

## See Also

[lynaghk/jetty7-websockets-async](https://github.com/lynaghk/jetty7-websockets-async)
provides a similar library for jetty7.

## License

Copyright © 2013 Logan Linn

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
