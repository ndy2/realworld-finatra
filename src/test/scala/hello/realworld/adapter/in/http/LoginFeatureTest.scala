package hello.realworld.adapter.in.http

import com.twitter.finatra.http.EmbeddedHttpServer
import com.twitter.inject.server.FeatureTest
import hello.realworld.Realworld
import hello.realworld.adapter.in.model.UserResp

class LoginFeatureTest extends FeatureTest {

  val server = new EmbeddedHttpServer(
    twitterServer = new Realworld
  )

  test("LoginController#login") {
    // when
    val response: UserResp = server.httpPostJson[UserResp](
      path = "/users/login",
      postBody = ""
    )

    // then
    response shouldEqual UserResp(
      email = "jake@jake.jake",
      token = "jwt.token.here",
      username = Some("jake"),
      bio = Some("I work at statefarm"),
      image = None
    )
  }
}
