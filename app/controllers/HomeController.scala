package controllers

import javax.inject._
import play.api._
import play.api.mvc._

/** The controller of the home page. */
@Singleton
class HomeController @Inject() extends Controller {
  def index = Action {
    Ok(views.html.index())
  }

  def contactPost = Action {
    Ok(views.html.index())
  }
}
