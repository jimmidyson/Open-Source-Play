package gaeunfilteredscalateexample

import unfiltered.request._
import unfiltered.response._
import unfiltered.scalate._

import org.fusesource.scalate.TemplateEngine
import org.fusesource.scalate.layout.DefaultLayoutStrategy

class App extends unfiltered.filter.Plan {
  val templateDirs = List(new java.io.File("WEB-INF/scalate"))
  val scalateMode = "production"
  implicit val engine = new TemplateEngine(templateDirs, scalateMode)
  engine.allowReload = false
  engine.workingDirectory = new java.io.File("WEB-INF/scalate")
  engine.layoutStrategy = new DefaultLayoutStrategy(engine, "layouts/default.ssp")

  def intent = {
    case req => Ok ~> Scalate(req, "templates/hello.ssp")
  }
}
