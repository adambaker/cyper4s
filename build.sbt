
calaSource in Compile := baseDirectory.value / "src"
scalaSource in Test := baseDirectory.value / "test"

name := "sample-name"
version := "0.0.1-SNAPSHOT"

libraryDependencies ++= Seq(
  "org.neo4j" % "neo4j" % "3.1.2",
  "org.neo4j" % "neo4j-cypher" % "3.1.2",
  "com.lihaoyi" %% "utest" % "0.5.3" % "test",
  "org.neo4j.driver" % "neo4j-java-driver" % "1.2.1")

testFrameworks += new TestFramework("utest.runner.Framework")
