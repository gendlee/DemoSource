package chap5.circlequeue;

public class CirlcleQueueTest {
    public static void main(String[] args) throws Exception {
        // 1、创建循环队列
        CirlcleQueue cirlcleQueue = new CirlcleQueue(4);
        // 2、入队：5、8、4、7
        cirlcleQueue.enqueue(5);
        cirlcleQueue.enqueue(8);
        cirlcleQueue.enqueue(4);
        cirlcleQueue.enqueue(7);
        // 3、打印队列
        cirlcleQueue.print(); // 输出：[0(front)][5] [8] [4] [7(rear)]
        // 4、继续入队：9
        //cirlcleQueue.enqueue(9); // 输出异常：队列已满！

        // 5、出队：5
        cirlcleQueue.dequeue();
        cirlcleQueue.print(); // 输出：[0] [5(front)][8] [4] [7(rear)]

        // 6、入队：9
        cirlcleQueue.enqueue(9);
        cirlcleQueue.print(); // 输出：[9(rear)][5(front)][8] [4] [7]

        // 7、出队：8
        System.out.println(cirlcleQueue.dequeue());
        cirlcleQueue.print(); // 输出：[9(rear)][5][8(front)] [4] [7]

        // 8、入队：-1
        cirlcleQueue.enqueue(-1);
        cirlcleQueue.print(); // 输出：[9(rear)][5][8(front)] [4] [7]



    }
}
