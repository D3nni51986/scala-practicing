package kafka.basic.consumer

import models.Person
import utils.ProjectConfig
import kafka.Records._

object ConsumerMain extends App {

  val c = Consumer[Person](ProjectConfig.bootStrap)
  c.subscribe()
  c.poll()

}
