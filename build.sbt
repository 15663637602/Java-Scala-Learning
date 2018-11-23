lazy val java = (project in file("java"))
  .settings(
    name := "java-learn"
  )

lazy val spark = (project in file("spark"))
  .settings(
    name := "spark-practice",
    version := "0.1",
    scalaVersion := "2.11.8",
    libraryDependencies ++= Seq("org.apache.hadoop" % "hadoop-client" % Versions.hadoop % "compile, provided"
      exclude("commons-logging", "commons-logging")
      ,
      "org.apache.spark" %% "spark-core" % Versions.spark
        exclude("commons-logging", "commons-logging")
      ,
      "org.apache.spark" %% "spark-sql" % Versions.spark
        exclude("commons-logging", "commons-logging")
      ,
      "org.apache.spark" %% "spark-hive" % Versions.spark % "provided"
        exclude("commons-logging", "commons-logging")
        exclude("stax", "stax-api")
      ,
      "org.apache.spark" %% "spark-streaming" % Versions.spark % "provided"
        exclude("commons-logging", "commons-logging")
        exclude("stax", "stax-api"),
      "org.scalatest" %% "scalatest" % "3.0.5" % "test",
      "net.snowflake" % "snowflake-jdbc" % Versions.snowflakeJdbc % "runtime",
      "net.snowflake" % "spark-snowflake_2.11" % Versions.snowflakeSpark
    )
  )

lazy val scalal = (project in file("scalal"))
  .settings(
    name := "scalaLearn",
    scalaVersion := "2.11.8",
    libraryDependencies += "org.apache.tika" % "tika-core" % Versions.tika
  )

lazy val scalaFx = (project in file("scalaFx"))
  .settings(
    name := "scalaFx",
    scalaVersion := "2.11.8",
    libraryDependencies += "org.scalafx" %% "scalafx" % "8.0.144-R12"
  )