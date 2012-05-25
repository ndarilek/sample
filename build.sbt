name := "StackMan"

version := "0.1.0"

scalaVersion := "2.9.1"

seq(webSettings :_*)

resolvers += ScalaToolsSnapshots

//checksums := Nil

{
  val liftVersion = "2.4"
  libraryDependencies ++= Seq(
    "net.liftweb" %% "lift-webkit" % liftVersion % "compile->default",
    "net.liftweb" %% "lift-mongodb-record" % liftVersion % "compile->default",
    "org.eclipse.jetty" % "jetty-webapp" % "7.3.0.v20110203" % "container",
    "junit" % "junit" % "4.5" % "test->default",
    "ch.qos.logback" % "logback-classic" % "0.9.26"
  )
}
