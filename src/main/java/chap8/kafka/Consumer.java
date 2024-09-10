package chap8.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import java.util.Arrays;
import java.util.Properties;

/**
 * 消费者程序，需要另开一个窗口单独运行，与Producer程序同时运行
 */
public class Consumer {
    // 和Producer的Topic一致
    static String myTopic = "Topic-0";
    public static void main(String[] args) {

        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");// kakfa服务的地址
        props.put("group.id", "test");  // 制定消费组
        props.put("enable.auto.commit", "true");  // 自动确认offset
        props.put("auto.commit.interval.ms", "1000"); // 自动确认offset的时间间隔
        // key的序列化类
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        // value的序列化类
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        KafkaConsumer<String, String> consumer = new KafkaConsumer(props);

        // 消费者订阅的topic，与Producer一致
        consumer.subscribe(Arrays.asList(myTopic));

        while (true) {
            // 每隔2秒拉取一次数据
            ConsumerRecords<String, String> records = consumer.poll(2000);
            for (ConsumerRecord<String, String> record : records)
                System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
        }
    }
}
