import com.fasterxml.jackson.databind.{DeserializationFeature, ObjectMapper, SerializationFeature}
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import hello.realworld.adapter.in.model.UserResp
object Main extends App {
  // ObjectMapper 생성
  val objectMapper = new ObjectMapper()
  objectMapper.enable(SerializationFeature.WRAP_ROOT_VALUE)
  objectMapper.enable(DeserializationFeature.UNWRAP_ROOT_VALUE)

  objectMapper
    .registerModule(DefaultScalaModule)

  // 사용자 정보를 나타내는 객체 생성
  val userResponse = UserResp("jake@jake.jake", "jwt.token.here", Some("jake"), Some("I work at statefarm"), None)

  // 객체를 JSON 문자열로 변환
  val jsonString = objectMapper.writeValueAsString(userResponse)

  // 출력
  println(jsonString)
//  val target = jsonString
  val target =
    """{"user":{"email":"jake@jake.jake","token":"jwt.token.here","username":"jake","bio":"I work at statefarm"}}"""

  private val value = objectMapper.readValue(target, classOf[UserResp])
  println(value)
}
