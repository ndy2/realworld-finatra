package hello.realworld

import com.twitter.finatra.thrift.ThriftServer
import com.twitter.finatra.thrift.filters.{AccessLoggingFilter, LoggingMDCFilter, StatsFilter, ThriftMDCFilter, TraceIdMDCFilter}
import com.twitter.finatra.thrift.routing.ThriftRouter
import hello.realworld.controller.PingController

object Realworld extends ThriftServer{

  override protected def configureThrift(router: ThriftRouter): Unit = {
    router
      .filter[LoggingMDCFilter]
      .filter[TraceIdMDCFilter]
      .filter[ThriftMDCFilter]
      .filter[AccessLoggingFilter]
      .filter[StatsFilter]
      .add[PingController]
  }
}
