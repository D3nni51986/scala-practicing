package kafka.basic.producer

import java.util.Properties
import java.util.concurrent.Future

import kafka.Record
import kafka.config.KafkaConfig
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord, RecordMetadata}

object Producer{
  def apply[T](servers: String, customConfig: Option[Properties] = None)(implicit record: Record[T]): Producer[T] = {
    val conf = KafkaConfig(servers)
    customConfig.map(_ => conf.putAll(_))
    new Producer[T](conf)
  }
}

class Producer[T](config: Properties)(implicit val record: Record[T]) extends ProducerOps[T]{

  val producer = new KafkaProducer[String, String](config)

  override def send(data:T): Future[RecordMetadata] = producer.send(new ProducerRecord[String, String](record.topic, record.encode(data)))
}

trait ProducerOps[T]{
  def send(data:T): Future[RecordMetadata]
}


