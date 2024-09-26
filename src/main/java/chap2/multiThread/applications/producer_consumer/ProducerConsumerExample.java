package chap2.multiThread.applications.producer_consumer;

/**
 * 多线程模拟生产者-消费者
 */
public class ProducerConsumerExample {
    public static void main(String[] args) throws InterruptedException {
        // 创建一个共享的缓冲区：最多能存储7个值
        Buffer buffer = new Buffer(7);

        // 创建生产者线程
        Thread producerThread1 = new Thread(new Producer(buffer));
        Thread producerThread2 = new Thread(new Producer(buffer));
        // 创建消费者线程
        Thread consumerThread3 = new Thread(new Consumer(buffer));
        Thread consumerThread4 = new Thread(new Consumer(buffer));

        // 启动线程
        producerThread1.start();
        producerThread2.start();
        consumerThread3.start();
        consumerThread4.start();
        // 主线程等待生产者和消费者线程完成
        producerThread1.join();
        producerThread2.join();
        consumerThread3.join();
        consumerThread4.join();
    }
}
