import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.gc.ejemplos",
      scalaVersion := "2.10.5",
      version := "0.1.0-SNAPSHOT"
    )),
    name := "Case Class",
    libraryDependencies += scalaTest % Test
  )
