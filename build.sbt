lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  .settings(
    name := """play-scala-slick-example""",
    version := "2.8.x",
    scalaVersion := "2.13.6",
    libraryDependencies ++= Seq(
      guice,
      "com.typesafe.play" %% "play-slick" % "5.0.0",
      "com.typesafe.play" %% "play-slick-evolutions" % "5.0.0",
      "org.postgresql" % "postgresql" % "42.2.24",
      specs2 % Test,
    ),
    scalacOptions ++= Seq(
      "-feature",
      "-deprecation",
      "-Xfatal-warnings"
    )
  )
