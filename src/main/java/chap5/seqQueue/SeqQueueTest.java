package chap5.seqQueue;

public class SeqQueueTest {
    public static void main(String[] args) throws Exception {
        // 1、创建队列
        int maxSize = 6;
        SeqQueue seqQueue = new SeqQueue(maxSize);

        // 2、入队 5 8 4 7
        seqQueue.enqueue(5);
        seqQueue.enqueue(8);
        seqQueue.enqueue(4);
        seqQueue.enqueue(7);
        seqQueue.print(); // 输出：[front] [5] [8] [4] [7 (rear)]

        // 3、出队
        System.out.println("出队元素为：" + seqQueue.dequeue());  // 输出：5
        seqQueue.print(); // 输出：[front] [8] [4] [7 (rear)]

        // 4、获取头部和尾部元素
        System.out.println("头部元素为：" + seqQueue.getHeadElement());  // 输出：8
        System.out.println("尾部元素为：" + seqQueue.getRearElement());  // 输出：7

        // 5、入队
        seqQueue.enqueue(2);
        seqQueue.print(); // 输出：[front] [8] [4] [7] [2 (rear)]

    }
}
