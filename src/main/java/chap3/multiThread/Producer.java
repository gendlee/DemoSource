package chap3.multiThread;

public class Producer implements Runnable {
    private Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        int value = 0;
        try {
            while (true) {
                buffer.produce(value++); // 生产一个数据
                Thread.sleep(500); // 模拟生产的耗时
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
