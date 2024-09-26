package chap2.multiThread.applications.producer_consumer;

// 消费者程序
public class Consumer implements Runnable {
    private Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            while (true) {
                buffer.consume(); // 消费一个数据
                Thread.sleep(1000); // 模拟消费的耗时
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}