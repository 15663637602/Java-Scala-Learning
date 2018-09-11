lazy val java = (project in file("java"))
  .settings(
    name := "java-learn"
  )

lazy val spark = (project in file("spark"))
  .settings(
    name := "spark-practice",
    version := "0.1",
    scalaVersion := "2.11.8",
    libraryDependencies ++= Seq("org.apache.hadoop" % "hadoop-client" % Versions.hadoop % "provided"
      exclude("commons-logging", "commons-logging")
      ,
      "org.apache.spark" %% "spark-core" % Versions.spark % "provided"
        exclude("commons-logging", "commons-logging")
      ,
      "org.apache.spark" %% "spark-sql" % Versions.spark % "provided"
        exclude("commons-logging", "commons-logging")
      ,
      "org.apache.spark" %% "spark-hive" % Versions.spark % "provided"
        exclude("commons-logging", "commons-logging")
        exclude("stax", "stax-api")
      ,
      "org.apache.spark" %% "spark-streaming" % Versions.spark % "provided"
        exclude("commons-logging", "commons-logging")
        exclude("stax", "stax-api"),
      "org.scalatest" %% "scalatest" % "3.0.5" % "test"
    )
  )