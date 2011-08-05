package gaeunfilteredscalateexample

object Main extends com.weiglewilczek.slf4s.Logging {
  def main(args: Array[String]) {
    val server = unfiltered.jetty.Http(8080).filter(new App()).run
  }
}
