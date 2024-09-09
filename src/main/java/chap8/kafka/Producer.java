package chap8.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import java.util.Properties;

/**
 * 生产者程序，单独运行
 */
public class Producer {
    // 定义一个Topic
    static String myTopic = "Topic-0";
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("acks", "all");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        KafkaProducer producer = new KafkaProducer(props);
        for (int i = 0; i < 10000; i++) {
            producer.send(new ProducerRecord<String, String>("Topic-0", " key_" + i, "val_" + i));
            try {
                Thread.sleep(2000); // 2秒发一个消息
            } catch (InterruptedException e) {
                System.out.println("中断");
            }
        }

        producer.close();
    }
}
