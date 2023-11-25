package hello.realworld.config

import com.fasterxml.jackson.databind.{DeserializationFeature, ObjectMapper, SerializationFeature}
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.twitter.finatra.jackson.modules.ScalaObjectMapperModule
import hello.realworld.adapter.in.model.{LoginReq, UserResp}

object RealworldObjectMapperModule extends ScalaObjectMapperModule {

  override protected def additionalMapperConfiguration(mapper: ObjectMapper): Unit = {
    mapper
      .enable(SerializationFeature.WRAP_ROOT_VALUE)
      .enable(DeserializationFeature.UNWRAP_ROOT_VALUE)
      .enable(DeserializationFeature.FAIL_ON_NULL_CREATOR_PROPERTIES)
      .registerModule(DefaultScalaModule)

    mapper.readValue(mapper.writeValueAsString(LoginReq("a", "b")), classOf[LoginReq])
    mapper.readValue(mapper.writeValueAsString(UserResp("a", "b", Some("c"), None, None)), classOf[UserResp])
  }
}
