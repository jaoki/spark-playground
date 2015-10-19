name := "streaming-example1"
version := "0.1"

// libraryDependencies += "org.apache.spark" %% "spark-core" % "1.5.1"
libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "1.5.1",
  "org.apache.spark" %% "spark-streaming" % "1.5.1"
)


