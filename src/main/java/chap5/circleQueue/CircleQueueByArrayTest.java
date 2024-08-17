package chap5.circleQueue;

public class CircleQueueByArrayTest {
    public static void main(String[] args) throws Exception {
        // 1、创建循环队列
        CircleQueueByArray circleQueueByArray = new CircleQueueByArray(4);
        // 2、入队：5、8、4、7
        circleQueueByArray.enqueue(5);
        circleQueueByArray.enqueue(8);
        circleQueueByArray.enqueue(4);
        circleQueueByArray.enqueue(7);
        // 3、打印队列
        circleQueueByArray.print(); // 输出：[0(front)][5] [8] [4] [7(rear)]
        // 4、继续入队：9
        //circleQueueByArray.enqueue(9); // 输出异常：队列已满！

        // 5、出队：5
        circleQueueByArray.dequeue();
        circleQueueByArray.print(); // 输出：[0] [5(front)][8] [4] [7(rear)]

        // 6、入队：9
        circleQueueByArray.enqueue(9);
        circleQueueByArray.print(); // 输出：[9(rear)][5(front)][8] [4] [7]

        // 7、出队：8
        System.out.println(circleQueueByArray.dequeue());
        circleQueueByArray.print(); // 输出：[9(rear)][5][8(front)] [4] [7]

        // 8、入队：-1
        circleQueueByArray.enqueue(-1);
        circleQueueByArray.print(); // 输出：[9(rear)][5][8(front)] [4] [7]



    }
}
