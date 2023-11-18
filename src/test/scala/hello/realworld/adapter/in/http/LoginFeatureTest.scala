package hello.realworld.adapter.in.http

import com.twitter.finatra.http.EmbeddedHttpServer
import com.twitter.inject.server.FeatureTest
import hello.realworld.Realworld
import hello.realworld.adapter.in.model.UserResponse

class LoginFeatureTest extends FeatureTest {

  val server = new EmbeddedHttpServer(
    twitterServer = new Realworld
  )

  test("LoginController#login") {
    // when
    val response: UserResponse = server.httpPostJson[UserResponse](
      path = "/users/login",
      postBody = ""
    )

    // then
    response shouldEqual UserResponse(
      email = "jake@jake.jake",
      token = "jwt.token.here",
      username = Some("jake"),
      bio = Some("I work at statefarm"),
      image = None
    )
  }
}
