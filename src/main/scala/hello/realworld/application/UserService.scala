package hello.realworld.application

import com.twitter.util.Future
import hello.realworld.domain.{ User, UserInfo, UserRepository }

class UserService(
    repository: UserRepository
) {
  def getUserInfo(userId: Long): Future[UserInfo] = {
    Future.value(UserInfo(userId))
  }

  def registerUser(user: User): Future[User] = {
    repository.save(user)
  }
}
