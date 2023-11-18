package hello.realworld.adapter.in.model

case class LoginReq(
                     email: String,
                     password: String
                   )

case class RegistrationReq(
                            username: String,
                            email: String,
                            password: String
                          )
case class UserResp(
                     email: String,
                     token: String,
                     username: Option[String],
                     bio: Option[String],
                     image: Option[String]
                   )
