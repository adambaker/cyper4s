
scalaSource in Compile := baseDirectory.value / "src"
scalaSource in Test := baseDirectory.value / "test"

name := "cypher4s"
version := "0.0.1-SNAPSHOT"
scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "org.neo4j" % "neo4j" % "3.1.2",
  "org.neo4j" % "neo4j-cypher" % "3.1.2",
  "org.neo4j.driver" % "neo4j-java-driver" % "1.5.1",
  "com.lihaoyi" %% "utest" % "0.5.3" % "test")

testFrameworks += new TestFramework("utest.runner.Framework")
