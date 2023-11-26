package hello.realworld.adapter.in.filter
import com.google.inject.Inject
import com.twitter.finagle.http.{ Request, Response, Status }
import com.twitter.finagle.{ Service, SimpleFilter }
import com.twitter.util.Future
import hello.realworld.application.UserService
import hello.realworld.domain.UserInfoContext

class AuthenticationFilter @Inject()(
  userService: UserService
) extends SimpleFilter[Request, Response] {
  def apply(request: Request, service: Service[Request, Response]): Future[Response] = {
    val authenticationHeader = request.headerMap.get("Authorization")
    val isAuthenticated      = authenticate(authenticationHeader)

    if (isAuthenticated) {
      // 토큰에서 userId를 추출합니다.
      val userId = extractUserId(authenticationHeader)

      // UserService를 사용하여 userId에 해당하는 사용자 정보를 가져옵니다.
      userService.getUserInfo(userId).flatMap { userInfo =>
        // ThreadLocal에 사용자 정보를 저장합니다.
        UserInfoContext.set(userInfo)

        // 다음 단계로 진행합니다.
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

  private def extractUserId(authHeader: Option[String]): String = {
    // 토큰에서 userId를 추출하는 로직을 여기에 추가합니다.
    // 실제로는 토큰 디코딩이나 검증 로직이 들어갈 것입니다.
    // 이 예제에서는 간단히 "Bearer token"에서 "token"을 추출합니다.
    authHeader.map(_.substring("Bearer ".length)).getOrElse("")
  }
}
