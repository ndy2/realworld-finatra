package hello.realworld.adapter.in.http

import com.twitter.finatra.http.Controller
import hello.realworld.adapter.in.model.{LoginReq, UserResp}

class LoginController extends Controller {

  post[LoginReq, UserResp]("/users/login") { req: LoginReq =>
    // binding
    val loginReq = req

    // response
    UserResp(
      email = "aaa",
      token = "jwt.token.here",
      username = Some("jake"),
      bio = Some("I work at statefarm"),
      image = None
    )
  }
}
