package hello.realworld.adapter.in.model

import com.fasterxml.jackson.annotation.JsonRootName

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
case class UserResp(
    email: String,
    token: String,
    username: Option[String],
    bio: Option[String],
    image: Option[String]
)
