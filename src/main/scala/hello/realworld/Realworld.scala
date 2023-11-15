package hello.realworld

import com.twitter.finatra.http.HttpServer
import com.twitter.finatra.http.routing.HttpRouter
import hello.realworld.adapter.in.http.LoginController



class Realworld extends HttpServer {

  override protected def configureHttp(router: HttpRouter): Unit = {
    router
      .add[LoginController]
  }
}
object ServerMain extends Realworld
