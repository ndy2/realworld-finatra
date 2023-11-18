package hello.realworld.adapter.in.model

case class UserResponse(
                         email: String,
                         token: String,
                         username: Option[String],
                         bio: Option[String],
                         image: Option[String]
                       )
