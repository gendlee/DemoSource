package chap2.multiThread.applications.producer_consumer;

import java.util.LinkedList;
import java.util.Queue;

// 缓冲区类，负责存储和传递数据
public class Buffer {
    private Queue<Integer> list; // 存储数据的队列
    private int capacity; // 缓冲区容量

    public Buffer(int capacity) {
        this.list = new LinkedList<>();
        this.capacity = capacity;
    }

    // 生产者放入数据
    public synchronized void produce(int value) throws InterruptedException {
        // 如果缓冲区满了，生产者需要等待
        while (list.size() == capacity) {
            System.out.println("Buffer is full, producer is waiting...");
            wait(); // 进入等待状态，释放锁
        }
        // 放入数据
        list.add(value);
        System.out.println("生产数据： " + value);
        // 通知消费者可以消费了
        notifyAll(); // 唤醒在等待的线程
    }

    // 消费者取出数据
    public synchronized int consume() throws InterruptedException {
        // 如果缓冲区为空，消费者需要等待
        while (list.isEmpty()) {
            System.out.println("Buffer is empty, consumer is waiting...");
            wait(); // 进入等待状态，释放锁
        }
        // 取出数据
        int value = list.poll();
        System.out.println("消费数据： " + value);
        // 通知生产者可以继续生产
        notifyAll(); // 唤醒在等待的线程
        return value;
    }
}
