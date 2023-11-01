ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion := "2.12.12"

lazy val versions = new {
  val finatra   = "22.12.0"
  val logback   = "1.4.7"
  val scalatest = "3.0.3"
  val jackson   = "2.9.0"
  val guice     = "5.1.0"
}

lazy val root = (project in file("."))
  .settings(
    name := "realworld-finatra",
    libraryDependencies ++= Seq(
      "com.twitter" %% "finatra-thrift" % versions.finatra excludeAll (
        ExclusionRule(organization = "com.fasterxml.jackson.module")
      ),
      "com.twitter" %% "finatra-thrift" % versions.finatra % "test" classifier "tests" excludeAll (
        ExclusionRule(organization = "com.fasterxml.jackson.module")
      ),
      "ch.qos.logback"                % "logback-classic"      % versions.logback,
      "com.twitter"                  %% "finatra-thrift"       % versions.finatra   % "test",
      "com.twitter"                  %% "inject-app"           % versions.finatra   % "test",
      "com.twitter"                  %% "inject-core"          % versions.finatra   % "test",
      "com.twitter"                  %% "inject-modules"       % versions.finatra   % "test",
      "com.twitter"                  %% "inject-server"        % versions.finatra   % "test",
      "com.google.inject.extensions"  % "guice-testlib"        % versions.guice     % "test",
      "com.twitter"                  %% "finatra-thrift"       % versions.finatra   % "test" classifier "tests",
      "com.twitter"                  %% "inject-app"           % versions.finatra   % "test" classifier "tests",
      "com.twitter"                  %% "inject-core"          % versions.finatra   % "test" classifier "tests",
      "com.twitter"                  %% "inject-modules"       % versions.finatra   % "test" classifier "tests",
      "com.twitter"                  %% "inject-server"        % versions.finatra   % "test" classifier "tests",
      "com.fasterxml.jackson.module" %% "jackson-module-scala" % versions.jackson,
      "org.scalatest"                %% "scalatest"            % versions.scalatest % "test"
    )
  )
