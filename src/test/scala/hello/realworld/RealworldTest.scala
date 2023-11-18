package hello.realworld

import com.google.inject.Stage
import com.twitter.finatra.http.EmbeddedHttpServer
import com.twitter.inject.server.FeatureTest

class RealworldTest extends FeatureTest {

  val server = new EmbeddedHttpServer(
    twitterServer = new Realworld,
    stage = Stage.PRODUCTION,
    disableTestLogging = true
  )

  test("Realworld#starts") {
    server.assertHealthy()
  }
}
