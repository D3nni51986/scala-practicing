package kafka

import io.circe.generic.auto._
import io.circe.syntax._
import models.{Event, Person}

object Records {

  implicit val eventRecord:Record[Event] = new Record[Event] {

    override def encode(data: Event): String = data.asJson.noSpaces

    override def decode(json: String): Option[Event] = io.circe.parser.decode[Event](json).right.toOption

    override def topic: String = "events"
  }

  implicit val personRecord:Record[Person] = new Record[Person] {

    override def encode(data: Person): String = data.asJson.noSpaces

    override def decode(json: String): Option[Person] = io.circe.parser.decode[Person](json).right.toOption

    override def topic: String = "persons"
  }
}

trait Record[T] {
  def topic: String
  def encode(data: T): String
  def decode(json: String): Option[T]
}