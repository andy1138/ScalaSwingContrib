name := "ScalaSwingContrib"

organization := "com.github.benhutchison"

version := "1.2"

scalaVersion := "2.9.2"

libraryDependencies ++= Seq(
  "org.scala-lang" % "scala-swing" % "2.9.2"
)

crossPaths := false

// Following settings taken from: 
//https://github.com/sbt/sbt.github.com/blob/gen-master/src/jekyll/using_sonatype.md

publishMavenStyle := true


publishTo <<= version { (v: String) =>
  val nexus = "https://oss.sonatype.org/"
  if (v.trim.endsWith("SNAPSHOT")) 
    Some("snapshots" at nexus + "content/repositories/snapshots") 
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}

//for local testing
//publishTo := Some(Resolver.file("file",  new File(Path.userHome.absolutePath+"/.m2/repository")))

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

pomExtra := (
  <url>http://github.com/benhutchison/ScalaSwingContrib</url>
  <licenses>
    <license>
      <name>BSD-style</name>
      <url>http://www.opensource.org/licenses/bsd-license.php</url>
      <distribution>repo</distribution>
    </license>
  </licenses>
  <scm>
    <url>git@github.com:benhutchison/ScalaSwingContrib.git</url>
    <connection>scm:git:git@github.com:benhutchison/ScalaSwingContrib.git</connection>
  </scm>
  <developers>
    <developer>
      <id>benhutchison</id>
      <name>Ben Hutchison</name>
      <url>http://github.com:benhutchison</url>
    </developer>
    <developer>
      <id>kenbot</id>
      <name>Ken Scambler</name>
      <url>http://github.com:kenbot</url>
    </developer>
  </developers>)
  
