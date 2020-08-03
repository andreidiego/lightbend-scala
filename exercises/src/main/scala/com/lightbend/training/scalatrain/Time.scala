package com.lightbend.training.scalatrain

import play.api.libs.json.JsValue
import play.api.libs.json.Json.obj

import scala.util.{Failure, Success, Try}

case class Time(hours: Int = 0, minutes: Int = 0) extends Ordered[Time] {
  require(hours >= 0 && hours <= 23, s"Invalid hours provided: $hours")
  require(minutes >= 0 && minutes <= 59, s"Invalid minutes provided: $minutes")

  override lazy val toString: String = f"$hours%02d:$minutes%02d"

  override def compare(that: Time): Int = asMinutes - that.asMinutes

  val asMinutes: Int = hours * 60 + minutes

  def minus(that: Time): Int = asMinutes - that.asMinutes

  def -(that: Time): Int = minus(that)

  def toJson: JsValue = obj("hours" -> hours, "minutes" -> minutes)
}

object Time {
  def fromMinutes(minutes: Int): Time = Time(minutes / 60, minutes % 60)

  def fromJson(json: JsValue): Option[Time] = Try((json \ "hours").as[Int]) match {
    case Failure(_) => None
    case Success(hours) => Some(Time(hours, Try((json \ "minutes").as[Int]).getOrElse(0)))
  }
}