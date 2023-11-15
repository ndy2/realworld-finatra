package hello.realworld.adapter.in.http

import com.twitter.finagle.http.Request
import com.twitter.finatra.http.Controller
class LoginController extends Controller {

  post("/login") { req: Request =>
    response.ok(s"login req : $req")
  }
}
