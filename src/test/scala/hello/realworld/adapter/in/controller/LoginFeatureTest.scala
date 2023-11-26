package hello.realworld.adapter.in.controller

import com.twitter.finagle.http.Response
import com.twitter.finagle.http.Status.Ok
import com.twitter.finatra.http.EmbeddedHttpServer
import com.twitter.inject.server.FeatureTest
import hello.realworld.Realworld
import hello.realworld.adapter.in.model.{ LoginReq, UserResp }

class LoginFeatureTest extends FeatureTest {

  val server = new EmbeddedHttpServer(
    twitterServer = new Realworld
  )

  test("LoginController#login") {
    // given
    val reqBody = server.mapper.writeValueAsString(
      new LoginReq(
        email = "jake@jake.jake",
        password = "jakejake"
      )
    )

    // when
    val response: Response = server.httpPost(
      path = "/users/login",
      postBody = reqBody
    )

    // then
    response.status should be(Ok)
    val respBody = server.mapper.parse[UserResp](response.content)
    respBody shouldEqual UserResp(
      email = "jake@jake.jake",
      token = "jwt.token.here",
      username = Some("jake"),
      bio = Some("I work at statefarm"),
      image = None
    )
  }
}
