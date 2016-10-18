package controllers

import com.google.inject.{Inject, Singleton}
import play.api.data.Forms._
import play.api.data._
import play.api.mvc._

/** The controller of the home page. */
@Singleton
class HomeController @Inject() extends Controller {
  /** Maps filled in user information from the contact form to a ContactRequest. */
  private implicit val contactForm = Form(
    mapping(
      "name" -> nonEmptyText,
      "surname" -> nonEmptyText,
      "email" -> email,
      "phone" -> text,
      "message" -> text
    )
    (ContactRequest.apply)(ContactRequest.unapply)
  )

  /** Returns the index page synchronously. */
  def index = Action {
    Ok(views.html.index())
  }

  /** Synchronously obtains the contact request and handles it. */
  def contactPost = Action { implicit request =>
    contactForm.bindFromRequest().fold(
      formWithErrors => {
        BadRequest(views.html.index())
      },

      contact => {
        // TODO

        Ok(views.html.index())
      }
    )
  }
}

case class ContactRequest(name: String, surname: String, email: String, phone: String, message: String)
