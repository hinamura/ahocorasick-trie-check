name := "ahocorasick-trie-check"

version := "1.0"

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  "com.ibm.icu" % "icu4j" % "53.1",
  "org.scalatest" %% "scalatest" % "2.2.4" % "test",
  "junit" % "junit" % "4.12" % "test",
  "com.novocode" % "junit-interface" % "0.11" % "test",
  "org.slf4j" % "slf4j-api" % "1.7.12",
  "ch.qos.logback" % "logback-classic" % "1.1.3",
  "com.typesafe.scala-logging" %% "scala-logging" % "3.1.0"
)