package chap5.linkedListQueue;

public class LinkedListQueueTest {
    public static void main(String[] args) throws Exception {
        int maxSize = 4;
        // 1、创建链式队列
        LinkedListQueue linkedListQueue = new LinkedListQueue(maxSize);
        // 2、入队 5 8 4 7
        linkedListQueue.enqueue(2);
        linkedListQueue.enqueue(5);
        linkedListQueue.enqueue(8);
        linkedListQueue.enqueue(7);
        linkedListQueue.print(); // 输出：[front]——>[2]——>[5]——>[8]——>[7(rear)]

        // 3、继续入队：9
        //linkedListQueue.enqueue(9); // 抛出异常：队列已满！

        // 4、出队：2
        linkedListQueue.dequeue();
        linkedListQueue.print(); // 输出：[front]——>[5]——>[8]——>[7(rear)]

        // 5、出队：5、8
        linkedListQueue.dequeue();
        linkedListQueue.dequeue();
        linkedListQueue.print(); // 输出：[front]——>[7(rear)]

        // 6、出队：7
        linkedListQueue.dequeue(); // 出队后队列为空
        linkedListQueue.print(); // 输出：无法打印，队列为空！

        // 7、入队：10
        linkedListQueue.enqueue(10);
        linkedListQueue.print(); // 输出：[front]——>[10(rear)]
    }
}
