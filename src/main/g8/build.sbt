organization := "$organization$"
name := "$name$"
version := "$version$"
scalaVersion := "$scalaVersion$"

scalacOptions := {
  val generalOpts = Seq(
    "-encoding", "utf8", "-feature", "-deprecation",
    "-Ywarn-unused", "-Ywarn-dead-code", "-Ywarn-unused-import", "-Ywarn-nullary-override")

  val specificOpts = CrossVersion.partialVersion(scalaVersion.value) match {
    case Some((2, 12)) =>
      Seq("-opt:l:method")

    case _ =>
      Seq()
 }
  generalOpts ++ specificOpts
}
