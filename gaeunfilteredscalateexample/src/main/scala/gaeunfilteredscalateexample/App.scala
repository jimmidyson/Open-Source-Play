package gaeunfilteredscalateexample

import unfiltered.request._
import unfiltered.response._
import unfiltered.scalate._

import QParams._

import org.fusesource.scalate.TemplateEngine
import org.fusesource.scalate.layout.DefaultLayoutStrategy

class App extends unfiltered.filter.Plan with com.weiglewilczek.slf4s.Logging {
  val templateDirs = List(new java.io.File("WEB-INF/scalate"))
  val scalateMode = "production"
  implicit val engine = new TemplateEngine(templateDirs, scalateMode)
  engine.allowReload = false
  engine.workingDirectory = new java.io.File("WEB-INF/scalate")
  engine.layoutStrategy = new DefaultLayoutStrategy(engine, "layouts/default.ssp")

  def intent = {
    case req @ Path("/") => req match {
      case GET(_) => Ok ~> Scalate(req, "templates/hello.ssp")
      case POST(_) => {
        val Params(form) = req
        logger.info("Received post with name: " + form("name"))
        form("name") match {
          case Nil => Redirect("/")
          case _ => Ok ~> Scalate(req, "templates/hello.ssp", ("name", form("name")(0)))
        }
      }
    }
  }
}
