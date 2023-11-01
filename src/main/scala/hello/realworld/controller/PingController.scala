package hello.realworld.controller

import com.twitter.finatra.thrift.Controller
import com.twitter.scrooge.{Request, Response}
import com.twitter.util.Future
import hello.realworld.PingService
import hello.realworld.PingService.{Echo, Ping}

class PingController extends Controller(PingService) {

  handle(Ping).withFn { _ =>
    Future(Response("pong"))
  }

  handle(Echo).withFn { arg: Request[Echo.Args] =>
    Future(Response(arg.args.a))
  }
}
