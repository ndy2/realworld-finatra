package hello.realworld.domain

import scala.concurrent.Future

case class User(
    id: Option[Long] = None,
    email: String,
    password: String
) {}

trait UserRepository {

  def save(user: User): Future[User]
  def findById(id: Long): Future[User]
}
