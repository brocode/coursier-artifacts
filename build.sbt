name := "coursier-artifacts"

libraryDependencies += "org.wildfly" % "wildfly-dist" % "8.2.1.Final" artifacts(Artifact("wildfly-dist", "bundle", "zip"))
val wildFly = TaskKey[Unit]("wildFly")

wildFly := {
  val sourceFile = url("http://download.jboss.org/wildfly/8.2.1.Final/wildfly-8.2.1.Final.zip")
  // the following blows up
  update.value.configuration("compile").get.modules.flatMap(_.artifacts).find(_._1.name == "wildfly-dist").get._2
}
