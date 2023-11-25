ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion := "2.12.12"

lazy val versions = new {
  val finatra   = "21.2.0"
  val scalatest = "3.1.2"
  val guice     = "5.1.0"
  val mockito   = "1.9.5"
}

lazy val root = (project in file("."))
  .settings(
    name := "realworld-finatra",
    organization := "hello.realworld",
    libraryDependencies ++= Seq(
      "com.typesafe"                 % "config"          % "1.3.1",
      "com.iheart"                  %% "ficus"           % "1.4.0",
      "com.zaxxer"                   % "HikariCP"        % "2.6.2",
      "ch.qos.logback"               % "logback-classic" % "1.2.3",
      "com.twitter"                 %% "finagle-thrift"  % versions.finatra,
      "com.twitter"                 %% "finatra-http"    % versions.finatra,
      "com.twitter"                 %% "scrooge-core"    % versions.finatra,
      "com.twitter"                 %% "finatra-http"    % versions.finatra   % "test",
      "com.twitter"                 %% "inject-server"   % versions.finatra   % "test",
      "com.twitter"                 %% "inject-app"      % versions.finatra   % "test",
      "com.twitter"                 %% "inject-core"     % versions.finatra   % "test",
      "com.twitter"                 %% "inject-modules"  % versions.finatra   % "test",
      "com.google.inject.extensions" % "guice-testlib"   % versions.guice     % "test",
      "com.twitter"                 %% "finatra-http"    % versions.finatra classifier "tests" withSources (),
      "com.twitter"                 %% "inject-server"   % versions.finatra classifier "tests",
      "com.twitter"                 %% "inject-app"      % versions.finatra classifier "tests",
      "com.twitter"                 %% "inject-core"     % versions.finatra classifier "tests",
      "com.twitter"                 %% "inject-modules"  % versions.finatra classifier "tests",
      "org.mockito"                  % "mockito-core"    % versions.mockito   % "test",
      "org.scalatest"               %% "scalatest"       % versions.scalatest % "test"
    )
  )
