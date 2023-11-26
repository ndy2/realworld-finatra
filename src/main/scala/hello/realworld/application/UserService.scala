package hello.realworld.application

import com.twitter.util.Future
import hello.realworld.domain.UserInfo

class UserService {
  def getUserInfo(userId: Long): Future[UserInfo] = {
    Future.value(UserInfo(userId))
  }
}
