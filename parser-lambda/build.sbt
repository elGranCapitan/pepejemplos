import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.10.5",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "mifid-parser",
    libraryDependencies += scalaTest % Test
  )
