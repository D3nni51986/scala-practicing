package utils

import java.io.File

import com.typesafe.config.ConfigFactory

object ProjectConfig {

  val configPath = "config\\"

  val kafkaConfigPath = "kafka.conf"

  lazy val kafkaConfig = ConfigFactory.parseFile(new File(configPath + kafkaConfigPath)).getConfig("kafka")

  val bootStrap = kafkaConfig.getString("bootStrapServers")
}
