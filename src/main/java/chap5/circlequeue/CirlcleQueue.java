package chap5.circlequeue;

public class CirlcleQueue {
    private int[] queue;  // 数组队列
    private int maxSize;  // 最大容量
    private int front;   // 队头指针
    private int rear;  // 队尾指针
    private int length;  // 元素个数

    // 构造函数
    public CirlcleQueue(int maxSize) {
        this.maxSize = maxSize + 1; //其中一个位置专门给front，所以+1
        this.queue = new int[maxSize + 1];
        this.front = 0;
        this.rear = 0;
        this.length = 0;
    }

    /**
     * 判断队列是否已满
     */
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    /**
     * 队列判空
     */
    public boolean isEmpty() {
        return rear == front;
    }

    /**
     * 入队
     * @param val 入队元素值
     * @throws Exception  队列已满异常
     */
    public void enqueue(int val) throws Exception {
        if (isFull()) {
            throw new Exception("队列已满！");
        }
        rear = (rear + 1) % maxSize;
        queue[rear] = val;
        length++;
    }

    /**
     * 出队
     * @return 出队元素
     * @throws Exception 队列为空异常
     */
    public int dequeue() throws Exception  {
        if (isEmpty()) {
            throw new Exception("队列为空！");
        }
        front = (front + 1) % maxSize;
        length--;
        return queue[front];
    }

    /**
     * 打印循环队列
     */
    public void print() {
        if (isEmpty()) {
            System.out.println("无法打印，队列为空！");
            return;
        }

        for (int i = 0; i < maxSize ; i++) {
            if (i == front) {
                System.out.print(String.format("[%d(front)] ", queue[i]));
            } else if (i == rear) {
                System.out.print(String.format("[%d(rear)] ", queue[i]));
            } else {
                System.out.print(String.format("[%d] ", queue[i]));
            }
        }
        System.out.println();
    }

    public int getFront() {
        return front;
    }

    public int getRear() {
        return rear;
    }

    public int getLength() {
        return length;
    }
}
