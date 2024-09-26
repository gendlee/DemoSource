package chap2.multiThread.applications.increase_number;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用3个线程打印1-100的数字，要求保证数字的连续递增
 * 使用：重入锁ReentrantLock+Condition
 */
public class IncrementalPrinterByLock {
    private int number = 1; // 要打印的数字，线程共享变量
    private final int limit = 100; // 打印上限
    private final Lock lock = new ReentrantLock(); // 重入锁
    private final Condition condition = lock.newCondition(); // 用于线程等待和唤醒的条件


    public void print() {
        while(true) {
            lock.lock(); // 加锁
            if (number > limit) {
                condition.signalAll(); // 通知其他线程
                return;
            }
            try {
                System.out.println(Thread.currentThread().getName() + ": " + number++);
                // 唤醒其他等待线程
                condition.signalAll();

                try {
                    // 当前线程等待，让其他线程有机会获取锁
                    condition.await();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            } finally {
                lock.unlock(); // 解锁
            }
        }

    }

    public static void main(String[] args) {
        IncrementalPrinterByLock printer = new IncrementalPrinterByLock();

        // 启动3个线程
        Thread t1 = new Thread(printer::print, "Thread-1");
        Thread t2 = new Thread(printer::print, "Thread-2");
        Thread t3 = new Thread(printer::print, "Thread-3");

        t1.start();
        t2.start();
        t3.start();
    }
}
