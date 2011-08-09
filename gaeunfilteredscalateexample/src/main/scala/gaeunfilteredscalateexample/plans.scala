package gaeunfilteredscalateexample

import unfiltered.request._

import unfiltered.response._
import unfiltered.scalate._

import QParams._

import org.fusesource.scalate.TemplateEngine
import org.fusesource.scalate.layout.DefaultLayoutStrategy

abstract class ScalateConfigurator {
  val templateDirs = List(new java.io.File("WEB-INF/scalate"))
  val scalateMode = "production"
  implicit val engine = new TemplateEngine(templateDirs, scalateMode)
  engine.allowReload = false
  engine.workingDirectory = new java.io.File("WEB-INF/scalate")
  engine.layoutStrategy = new DefaultLayoutStrategy(engine, "layouts/default.jade")
}

class SayHelloPlan extends ScalateConfigurator with unfiltered.filter.Plan with com.weiglewilczek.slf4s.Logging {
  val template = "templates/hello.ssp"

  def intent = {
    case req @ GET(Path(Seg(Nil))) => Ok ~> Scalate(req, "templates/hello.ssp")
    case req @ Path(Seg("hello" :: Nil)) => req match {
      case GET(_) => Ok ~> Scalate(req, template)
      case POST(_) => {
        val Params(form) = req
            logger.info("Received post with name: " + form("name"))
            form("name") match {
              case Nil => Redirect("/hello")
              case _ => Ok ~> Scalate(req, template, ("name", form("name")(0)))
        }
      }
    }
    case req @ GET(Path(Seg("hello" :: name :: Nil))) => Ok ~> Scalate(req, template, ("name", name))
    case _ => Pass
  }
}

class SayGoodbyePlan extends ScalateConfigurator with unfiltered.filter.Plan with com.weiglewilczek.slf4s.Logging {
  val template = "templates/goodbye.jade"

  def intent = {
    case req @ Path(Seg("goodbye" :: Nil)) => req match {
      case GET(_) => Ok ~> Scalate(req, template)
      case POST(_) => {
        val Params(form) = req
            logger.info("Received post with name: " + form("name"))
            form("name") match {
              case Nil => Redirect("/goodbye")
              case _ => Ok ~> Scalate(req, template, ("name", form("name")(0)))
        }
      }
    }
    case req @ GET(Path(Seg("goodbye" :: name :: Nil))) => Ok ~> Scalate(req, template, ("name", name))
    case _ => Pass
  }
}
