import sbt.Keys._
import sbt._
import sbtrelease.Version

name := "chineseTest"

resolvers += Resolver.sonatypeRepo("public")
scalaVersion := "2.12.3"
releaseNextVersion := { ver => Version(ver).map(_.bumpMinor.string).getOrElse("Error") }
assemblyJarName in assembly := "chineseTest.jar"

libraryDependencies ++= Seq(
  "com.amazonaws" % "aws-lambda-java-events" % "1.3.0",
  "com.amazonaws" % "aws-lambda-java-core" % "1.1.0"
)

javacOptions ++= Seq("-encoding", "UTF-8")

scalacOptions ++= Seq(
  "-unchecked",
  "-deprecation",
  "-feature",
  "-Xfatal-warnings")
