ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.2.0"

lazy val root = (project in file("."))
  .settings(
    name := "shopping_trolley"
  )

libraryDependencies += "com.lihaoyi" %% "upickle" % "3.0.0"
libraryDependencies += "com.lihaoyi" %% "os-lib" % "0.9.1"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.15" % "test"
