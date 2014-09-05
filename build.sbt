import UglifyKeys._
import WebJs._
import play.PlayImport.PlayKeys

name := """play-java"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava, SbtWeb)

pipelineStages := Seq(uglify, digest, gzip)

pipelineStages in Assets := Seq(uglify, digest, gzip)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  javaWs
)
