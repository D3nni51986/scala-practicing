package kafka.config

import java.util.Properties

object KafkaConfig {

  def apply(bootstrapServers: String): Properties = {
    val props = new Properties()
    props.put("bootstrap.servers", bootstrapServers)
    props.put ("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    props.put ("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")

    props.put("group.id", "test")
    props.put("enable.auto.commit", "true")
    props.put("auto.commit.interval.ms", "1000")
    props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
    props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
    props
  }
}

class KafkaConfig(bootstrapServers: String){
  val properties: Properties = KafkaConfig(bootstrapServers)
}