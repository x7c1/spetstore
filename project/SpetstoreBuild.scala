import sbt._
import Keys._
import play.Project._

object SpetstoreBuild extends Build {

  val appName = "spetstore"
  val appVersion = "1.0.0"

  val finagleVersion = "6.4.1"


  val finagleMemcached = "com.twitter" %% "finagle-memcached" % finagleVersion excludeAll(
    ExclusionRule(organization = "log4j", name = "log4j"),
    ExclusionRule(organization = "org.slf4j", name = "slf4j-api"),
    ExclusionRule(organization = "org.slf4j", name = "slf4j-jdk14"),
    ExclusionRule(organization = "org.slf4j", name = "slf4j-log4j12")
    )

  val appDependencies = Seq(
    jdbc,
        "org.scala-lang"          % "scala-reflect"               % "2.10.3",
        "junit"                   % "junit"                       % "4.8.1" % "test",
        "org.hamcrest"            % "hamcrest-all"                % "1.3" % "test",
        "org.mockito"             % "mockito-core"                % "1.9.5" % "test",
        "org.specs2"              %% "specs2"                     % "2.0" % "test",
        "net.codingwell"          %% "scala-guice"                % "4.0.0-beta",
        "com.github.nscala-time"  %% "nscala-time"                % "0.6.0",
        "org.scalikejdbc"         %% "scalikejdbc"                % "1.7.4",
        "org.scalikejdbc"         %% "scalikejdbc-test"           % "1.7.4" % "test",
        "org.scalikejdbc"         %% "scalikejdbc-interpolation"  % "1.7.4",
        "org.scalikejdbc"         %% "scalikejdbc-play-plugin"    % "1.7.4",
        "org.skinny-framework"    %% "skinny-orm"                 % "1.0.5",
        "com.h2database"          %  "h2"                         % "1.3.175",
        "ch.qos.logback"          %  "logback-classic"            % "[1.0,)",
        "org.json4s"              %% "json4s-ext"                 % "3.2.4",
        "org.json4s"              %% "json4s-jackson"             % "3.2.4",
        "com.github.tototoshi"    %% "play-json4s-jackson"        % "0.2.0",
        "com.github.tototoshi"    %% "play-json4s-test-jackson"   % "0.2.0" % "test",
        "com.github.tototoshi"    %% "play-json4s-native"         % "0.1.0",
        "com.github.tototoshi"    %% "play-flyway"                % "0.1.4",
    "mysql" % "mysql-connector-java" % "5.1.28"
  )

  val main = play.Project(appName, appVersion, appDependencies).settings(
      scalaVersion in ThisBuild := "2.10.4",
      conflictWarning := ConflictWarning.disable
  )

}
