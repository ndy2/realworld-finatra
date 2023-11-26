package hello.realworld.testsupport

import com.twitter.finagle.http.{Response, Status}
import com.twitter.finatra.jackson.ScalaObjectMapper
import org.scalatest.matchers.{MatchResult, Matcher}

trait FinagleHttpResponseMatchers {

  def beOkWithContent[T](expectedBody: T)(implicit mapper: ScalaObjectMapper, m: Manifest[T]): Matcher[Response] =
    haveStatusAndContent(Status.Ok, expectedBody)

  def haveStatusAndContent[T](
      expectedStatus: Status,
      expectedBody: T
  )(implicit
      mapper: ScalaObjectMapper,
      m: Manifest[T]
  ): Matcher[Response] =
    (response: Response) => {
      val statusMatch  = response.status == expectedStatus
      val contentMatch = mapper.parse[T](response.content) == expectedBody

      MatchResult(
        statusMatch && contentMatch,
        s"Response status was ${response.status}, but expected $expectedStatus and content was '${response.contentString}', but expected '$expectedBody'",
        s"Response status was $expectedStatus and content was '$expectedBody'"
      )
    }
}
