package kafka.basic.consumer

import java.util
import java.util.Properties

import kafka.Record

import kafka.config.KafkaConfig
import org.apache.kafka.clients.consumer.KafkaConsumer


object Consumer {
  def apply[T](servers: String, customConfig: Option[Properties] = None)(implicit record: Record[T]): Consumer[T] = {
    val conf = KafkaConfig(servers)
    customConfig.map(_ => conf.putAll(_))
    new Consumer[T](conf)
  }
}

class Consumer[T](config: Properties)(implicit val record: Record[T]) extends ConsumerOps[T]{

  val consumer = new KafkaConsumer[String, String](config)

  override def subscribe[T](): Unit = {
    consumer.subscribe(util.Arrays.asList(record.topic))
  }

  override def poll[T](): Unit = {
    while(true) {
      val consumerRecord = consumer.poll(100)
      consumerRecord.forEach(r =>{
        println(s"${r.value()} => ${record.decode(r.value())}")
      })
    }
  }
}

trait ConsumerOps[T]{
  def poll[T](): Unit
  def subscribe[T](): Unit
}