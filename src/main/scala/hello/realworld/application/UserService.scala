package hello.realworld.application

import com.twitter.util.Future
import hello.realworld.domain.UserInfo

class UserService {
  def getUserInfo(userId: String): Future[UserInfo] = {
    // 여기에서 사용자 정보를 데이터베이스나 다른 저장소에서 조회하는 로직을 가정합니다.
    // 실제로는 사용자 정보를 비동기적으로 조회하는 비즈니스 로직을 포함할 것입니다.
    Future.value(UserInfo(userId))
  }
}
