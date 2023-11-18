package hello.realworld.adapter.in.http

import com.twitter.finagle.http.Request
import com.twitter.finatra.http.Controller
import hello.realworld.adapter.in.model.UserResponse

class LoginController extends Controller {

  post("/users/login") { req: Request =>
    // response
    val body = UserResponse(
      email = "jake@jake.jake",
      token = "jwt.token.here",
      username = Some("jake"),
      bio = Some("I work at statefarm"),
      image = None
    )
    response.ok(body)
  }
}
