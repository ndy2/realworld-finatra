package hello.realworld.adapter.in.model

import com.fasterxml.jackson.annotation.JsonRootName
import hello.realworld.domain.User

@JsonRootName(value = "user")
case class LoginReq(
    email: String,
    password: String
)

@JsonRootName(value = "user")
case class RegistrationReq(
    username: String,
    email: String,
    password: String
)

@JsonRootName(value = "user")
case class UpdateUserReq(
    username: Option[String],
    email: Option[String],
    password: Option[String]
)

@JsonRootName(value = "user")
case class UserResp(
    email: String,
    token: String,
    username: Option[String],
    bio: Option[String],
    image: Option[String]
)

object UserResp {
  def of(user: User): UserResp = UserResp(
    email = "user.email",
    token = "???",
    username = Some("???"),
    bio = Some("???"),
    image = Some("???")
  )
}
