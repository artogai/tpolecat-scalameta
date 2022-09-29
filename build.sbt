import _root_.io.github.davidgregory084.ScalacOptions

ThisBuild / scalaVersion := "2.13.8"
ThisBuild / semanticdbEnabled := true
ThisBuild / semanticdbVersion := scalafixSemanticdb.revision

lazy val commonSettings = 
  Seq(
    Compile / tpolecatScalacOptions := Set()
  )

lazy val module1 = (project in file("module1"))
  .settings(name := "module1")
  .settings(commonSettings)

lazy val module2 = (project in file("module2"))
  .settings(name := "module2")
  .settings(commonSettings)

lazy val root = (project in file("."))
  .settings(name := "root")
  .aggregate(module1, module2)

Global / onChangedBuildSource := ReloadOnSourceChanges
