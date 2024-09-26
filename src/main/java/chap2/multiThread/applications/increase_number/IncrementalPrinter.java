package chap2.multiThread.applications.increase_number;

/**
 * 使用3个线程打印1-100的数字，要求保证数字的连续递增
 * 使用：synchronized
 */
public class IncrementalPrinter {
    private int number = 1; // 要打印的数字，线程共享变量
    private final int limit = 100; // 打印上限
    private final Object lock = new Object(); // 锁对象

    public void print() {
        while (true) {
            synchronized (lock) {
                if (number > limit) {
                    lock.notifyAll();  // 唤醒所有线程
                    return; // 如果打印完成，退出循环
                }
                System.out.println(Thread.currentThread().getName() + ": " + number++);

                // 唤醒其他等待的线程
                lock.notifyAll();

                try {
                    // 当前线程等待，让其他线程有机会获取锁
                    lock.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public static void main(String[] args) {
        IncrementalPrinter printer = new IncrementalPrinter();

        // 启动3个线程
        Thread t1 = new Thread(printer::print, "Thread-1");
        Thread t2 = new Thread(printer::print, "Thread-2");
        Thread t3 = new Thread(printer::print, "Thread-3");

        t1.start();
        t2.start();
        t3.start();
    }
}
