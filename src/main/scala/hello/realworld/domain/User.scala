package hello.realworld.domain

case class UserInfo(userId: String)

object UserInfoContext {

  private val userInfoThreadLocal = new ThreadLocal[UserInfo]

  def set(userInfo: UserInfo): Unit = userInfoThreadLocal.set(userInfo)
  def get(): UserInfo               = userInfoThreadLocal.get()
  def clear(): Unit                 = userInfoThreadLocal.remove()
}
