package hello.realworld.adapter.out.persistance

import hello.realworld.domain.{ User, UserRepository }
import slick.jdbc.H2Profile.api._

import scala.concurrent.Future
class UserTable(tag: Tag) extends Table[User](tag, "users") {
  def id       = column[Option[Long]]("id", O.PrimaryKey, O.AutoInc)
  def email    = column[String]("email")
  def password = column[String]("password")

  override def * = (id, email, password) <> (User.tupled, User.unapply)
}

class H2UserRepository extends UserRepository {

  private val users = TableQuery[UserTable]

  override def save(user: User): Future[User] = ???

  override def findById(id: Long): Future[User] = ???
}
