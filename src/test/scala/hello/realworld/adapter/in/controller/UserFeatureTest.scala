package hello.realworld.adapter.in.controller

import com.twitter.finagle.http.Response
import com.twitter.finatra.http.EmbeddedHttpServer
import com.twitter.finatra.jackson.ScalaObjectMapper
import com.twitter.inject.server.FeatureTest
import hello.realworld.Realworld
import hello.realworld.adapter.in.model.{ LoginReq, UserResp }
import hello.realworld.testsupport.FinagleHttpResponseMatchers

class UserFeatureTest extends FeatureTest with FinagleHttpResponseMatchers {

  val server: EmbeddedHttpServer = new EmbeddedHttpServer(
    twitterServer = new Realworld
  )
  implicit val mapper: ScalaObjectMapper = server.mapper

  test("UserController#Authentication") {
    // given
    val reqBody = mapper.writeValueAsString(
      LoginReq(
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
    response should beOkWithContent(
      UserResp(
        email = "jake@jake.jake",
        token = "jwt.token.here",
        username = Some("jake"),
        bio = Some("I work at statefarm"),
        image = None
      )
    )
  }

  test("UserController#Registration") {
    // given
    val reqBody = mapper.writeValueAsString(
      LoginReq(
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
    response should beOkWithContent(
      UserResp(
        email = "jake@jake.jake",
        token = "jwt.token.here",
        username = Some("jake"),
        bio = Some("I work at statefarm"),
        image = None
      )
    )
  }
}
