package hello.realworld.adapter.in.controller

import com.twitter.finagle.http.Request
import com.twitter.finatra.http.Controller
import hello.realworld.adapter.in.filter.AuthenticationFilter
import hello.realworld.adapter.in.model.{ LoginReq, RegistrationReq, UserResp }
import hello.realworld.domain.UserInfoContext._

class UserController extends Controller {

  post[LoginReq, UserResp](
    route = "/users/login",
    name = "Authentication"
  ) { req: LoginReq =>
    println(s"req = ${req}")

    // response
    UserResp(
      email = "jake@jake.jake",
      token = "jwt.token.here",
      username = Some("jake"),
      bio = Some("I work at statefarm"),
      image = None
    )
  }

  post[RegistrationReq, UserResp](
    route = "/users",
    name = "Registration"
  ) { req: RegistrationReq =>
    println(s"req = ${req}")

    // response
    UserResp(
      email = "jake@jake.jake",
      token = "jwt.token.here",
      username = Some("jake"),
      bio = Some("I work at statefarm"),
      image = None
    )
  }

  filter[AuthenticationFilter].get(
    route = "/user",
    name = " Get Current User"
  ) { req: Request =>
    println(s"req = ${req}")
    println(s"userInfo = ${req.userInfo}")

    response.ok.body("hi!")
  }
}
