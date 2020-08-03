package com.lightbend.training.scalatrain

case class Train(info: TrainInfo, schedule: Seq[(Time, Station)]) {
  require(schedule.size >= 2, "There must be at least 2 schedules for a train.")

  val stations: Seq[Station] = schedule.map(_._2)

  def timeAt(station: Station): Option[Time] = stopAt(station) match {
    case Some((time, _)) => Some(time)
    case None => None
  }

  private def stopAt(station: Station) = {
    schedule.find(_._2 == station)
  }
}