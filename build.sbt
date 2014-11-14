name := """akka-guice-sample"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.1"

resolvers += "snapshot repository" at "http://chanan.github.io/maven-repo/snapshots/"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  javaWs,
  "com.google.inject" % "guice" % "3.0",
  "net.sourceforge.htmlunit" % "htmlunit" % "2.15",
  "akkaguice" %% "akkaguice" % "0.8.2-SNAPSHOT"
)
