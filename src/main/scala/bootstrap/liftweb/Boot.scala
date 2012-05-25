package bootstrap.liftweb

import net.liftweb._
import common._
import http._
import sitemap._
import Loc._
import mongodb._
import util._
import Helpers._

import code._

/**
 * A class that's instantiated early and run.  It allows the application
 * to modify lift's environment
*/

class Boot {
  def boot {

    // where to search for snippets
    LiftRules.addToPackages("code")

    Props.requireOrDie("database")

    MongoDB.defineDb(
      DefaultMongoIdentifier,
      MongoAddress(MongoHost(), Props.get("database", ""))
    )

    // Build SiteMap
    LiftRules.setSiteMap(SiteMap((
      List(
        Menu.i("Home") / "index",
        snippet.Stacktrace.menu
      ):_*
    )))

    //Show the spinny image when an Ajax call starts
    LiftRules.ajaxStart =
      Full(() => LiftRules.jsArtifacts.show("ajax-loader").cmd)
    

    // Make the spinny image go away when it ends
    LiftRules.ajaxEnd =
      Full(() => LiftRules.jsArtifacts.hide("ajax-loader").cmd)

    // Force the request to be UTF-8
    LiftRules.early.append(_.setCharacterEncoding("UTF-8"))

    // Use HTML 5.
    LiftRules.htmlProperties.default.set((r: Req) => new Html5Properties(r.userAgent))

  }
}
