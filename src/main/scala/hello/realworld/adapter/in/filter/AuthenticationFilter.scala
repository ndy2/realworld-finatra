package hello.realworld.adapter.in.filter

import com.google.inject.Inject
import com.twitter.finagle.http.{Request, Response, Status}
import com.twitter.finagle.{Service, SimpleFilter}
import com.twitter.util.Future
import hello.realworld.application.UserService
import hello.realworld.domain.UserInfoContext

class AuthenticationFilter @Inject() (
    userService: UserService
) extends SimpleFilter[Request, Response] {
  def apply(request: Request, service: Service[Request, Response]): Future[Response] = {
    val authenticationHeader = request.headerMap.get("Authorization")
    val isAuthenticated      = authenticate(authenticationHeader)

    if (isAuthenticated) {
      val userId = extractUserId(authenticationHeader)
      userService.getUserInfo(userId).flatMap { userInfo =>
        UserInfoContext.setUserInfo(request, userInfo)

        service(request)
      }
    } else {
      val response = Response(Status.Unauthorized)
      response.setContentString("Authentication failed")
      Future.value(response)
    }
  }

  private def authenticate(authHeader: Option[String]): Boolean = {
    authHeader.exists(_.startsWith("Bearer "))
  }

  private def extractUserId(authHeader: Option[String]): Long = {
    authHeader.map(_.substring("Bearer ".length)).map(_.toLong).get
  }
}
