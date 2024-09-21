package chap3.multiThread;

/**
 * 多线程模拟生产者-消费者
 */
public class ProducerConsumerExample {
    public static void main(String[] args) throws InterruptedException {
        // 创建一个共享的缓冲区
        Buffer buffer = new Buffer(4); // 缓冲区最多能存储4个项目

        // 创建生产者线程
        Thread producerThread = new Thread(new Producer(buffer));
        // 创建消费者线程
        Thread consumerThread = new Thread(new Consumer(buffer));

        // 启动线程
        producerThread.start();
        consumerThread.start();

        // 主线程等待生产者和消费者线程完成
        producerThread.join();
        consumerThread.join();
    }
}
