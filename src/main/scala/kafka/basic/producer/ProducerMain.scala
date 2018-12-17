package kafka.basic.producer

import models.Person
import utils.ProjectConfig
import kafka.Records._

object ProducerMain extends App{

  val producer = Producer[Person](ProjectConfig.bootStrap)
  producer.send(Person("Dennis"))
  Thread.sleep(5000)

}
