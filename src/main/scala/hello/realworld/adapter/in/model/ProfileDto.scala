package hello.realworld.adapter.in.model


case class UpdateProfileReq(
                             username: Option[String],
                             email: Option[String],
                             bio: Option[String],
                             image: Option[String]
                           )

case class ProfileResp(
                        username: String,
                        bio: Option[String],
                        image: Option[String],
                        following: Boolean
                      )
