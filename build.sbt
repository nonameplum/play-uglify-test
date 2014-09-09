import com.mariussoutier.sbt.Imports.ConcatKeys
import com.typesafe.sbt.web.SbtWeb
import play.PlayJava
import sbt._

name := """play-java"""

version := "1.0-SNAPSHOT"

scalaVersion := "2.11.1"

lazy val root = (project in file(".")).enablePlugins(PlayJava, SbtWeb)

ConcatKeys.fileSeparator := "\n"

ConcatKeys.concatOpts := Map(
  "javascripts/first.js" -> new FileFilter {
    override def accept(pathname: File): Boolean = {
      pathname.getName == "a.js" || pathname.getName == "b.js"
    }
  },
  "javascripts/second.js" -> new FileFilter {
    override def accept(pathname: File): Boolean = {
      pathname.getName == "x.js" || pathname.getName == "y.js"
    }
  }
)

//pipelineStages := Seq(uglify, digest, gzip)
pipelineStages in Assets := Seq(concat, uglify, digest, gzip)

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  javaWs
)
