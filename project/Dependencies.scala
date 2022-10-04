import sbt._

object Dependencies {
  lazy val scalaTest = Seq(
    "org.scalatest" %% "scalatest" % "3.2.11",
    "org.scalacheck" %% "scalacheck" % "1.15.4",
    "com.github.alexarchambault" %% "scalacheck-shapeless_1.15" % "1.3.0" % Test
  )

  val circeVersion = "0.13.0"
  val pureconfigVersion = "0.15.0"
  val sparkVersion = "3.0.1"

  lazy val core = Seq(
    // support for JSON formats
    "io.circe" %% "circe-core" % circeVersion,
    "io.circe" %% "circe-generic" % circeVersion,
    "io.circe" %% "circe-parser" % circeVersion,
    "io.circe" %% "circe-literal" % circeVersion,
    // support for typesafe configuration
    "com.github.pureconfig" %% "pureconfig" % pureconfigVersion,
    // parallel collections
    "org.scala-lang.modules" %% "scala-parallel-collections" % "1.0.4",

    // spark
    // "org.apache.spark" %% "spark-sql" % sparkVersion % Provided, // for submiting spark app as a job to cluster
    "org.apache.spark" %% "spark-sql_2.12" % sparkVersion, // for simple standalone spark app
    "org.apache.spark" %% "spark-avro_2.12" % sparkVersion,
    "org.apache.spark" %% "spark-core_2.12" % sparkVersion,

    // logging
    "com.typesafe.scala-logging" %% "scala-logging" % "3.9.2",
    "ch.qos.logback" % "logback-classic" % "1.2.3"
  )

}
