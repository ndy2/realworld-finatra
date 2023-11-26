package hello.realworld.domain

import com.twitter.finagle.http.Request

// domain object to set as a RecordSchema field
case class UserInfo(id: Long)

// create a context
object UserInfoContext {
  private val UserInfoField = Request.Schema.newField[UserInfo]() // provide a default value

  implicit class UserInfoContextSyntax(val request: Request) extends AnyVal {
    def userInfo: UserInfo = request.ctx(UserInfoField)
  }

  private[twitter] def setUserInfo(request: Request, userInfo: UserInfo): Unit = {
    request.ctx.update(UserInfoField, userInfo)
  }
}
