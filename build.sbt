name := "scala-practicing"

version := "0.1"

scalaVersion := "2.12.8"

val circeVersion = "0.10.0"

libraryDependencies ++= Seq(
  "org.apache.kafka" % "kafka-streams" % "0.10.2.0",
  "org.slf4j" % "slf4j-log4j12" % "1.7.25",
  "com.typesafe.scala-logging" %% "scala-logging" % "3.5.0",
  "io.circe" %% "circe-core" % circeVersion,
  "io.circe" %% "circe-generic" % circeVersion,
  "io.circe" %% "circe-parser" % circeVersion,
  "com.goyeau" %% "kafka-streams-circe" % "0.5",
  "com.typesafe" % "config" % "1.3.2"
)