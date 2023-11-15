package hello.realworld

import com.twitter.finatra.http.EmbeddedHttpServer
import com.twitter.inject.server.FeatureTest

class RealworldTest extends FeatureTest {


  val server = new EmbeddedHttpServer(
    twitterServer = new Realworld
  )

  test("Realworld#starts") {
    server.isHealthy should be(true)
  }

  override protected def afterAll(): Unit = {
    server.close()
  }
}
