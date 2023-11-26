package hello.realworld

import com.google.inject
import com.twitter.finatra.http.HttpServer
import com.twitter.finatra.http.routing.HttpRouter
import hello.realworld.adapter.in.controller.LoginController
import hello.realworld.config.RealworldObjectMapperModule

class Realworld extends HttpServer {

  override protected def configureHttp(router: HttpRouter): Unit = {
    router
      .add[LoginController]
  }

  override protected def jacksonModule: inject.Module = RealworldObjectMapperModule
}
object ServerMain extends Realworld
