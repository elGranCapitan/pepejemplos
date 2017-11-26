import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.gc",
      scalaVersion := "2.10.5",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "Option",
    libraryDependencies += scalaTest % Test
  )
