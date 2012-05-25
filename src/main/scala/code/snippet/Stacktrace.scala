package code
package snippet

import xml._

import net.liftweb._
import common._
import http._
import js._
import JsCmds._
import js.jquery.JqJsCmds._
import S._
import SHtml._
import sitemap._
import SiteMap._
import Loc._
import util._
import Helpers._

object Stacktrace {

  lazy val menu = Menu.param[String](
    "Show", "Show",
    Full(_),
    { (v:String) => v }
  ) / "stacktraces" >>
  Template(() => TemplateFinder.findAnyTemplate("stacktrace" :: Nil).openOr(NodeSeq.Empty))

  def render = NodeSeq.Empty

}
