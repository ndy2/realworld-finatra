package hello.realworld.config

import com.fasterxml.jackson.databind.{DeserializationFeature, ObjectMapper, SerializationFeature}
import com.twitter.finatra.jackson.modules.ScalaObjectMapperModule

object RealworldObjectMapperModule extends ScalaObjectMapperModule {

  override protected def additionalMapperConfiguration(mapper: ObjectMapper): Unit = {
    mapper.enable(SerializationFeature.WRAP_ROOT_VALUE)
    // is there is a bug?
    mapper.enable(DeserializationFeature.UNWRAP_ROOT_VALUE)
  }
}
