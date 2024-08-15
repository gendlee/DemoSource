package chap5.seqQueue;

public class SeqQueue {
    private int[] queue;  // 数组队列
    private int maxSize;  // 最大容量
    private int front;   // 队头指针
    private int rear;  // 队尾指针

    // 构造函数
    public SeqQueue(int maxSize) {
        this.queue = new int[maxSize];
        this.maxSize = maxSize;
        this.front = -1;
        this.rear = -1;
    }

    /**
     * 判断队列是否已满
     */
    public boolean isFull() {
        return rear == (maxSize - 1);
    }

    /**
     * 判断队列是否为空
     */
    public boolean isEmpty() {
        return front == rear;
    }

    /**
     * 入队
     * @param val 入队元素
     * @throws Exception
     */
    public void enqueue(int val) throws Exception {
        if (isFull()) {
            throw new Exception("队列已满！");
        }
        queue[++rear] = val;  // 注意这里rear先自增再引用
    }

    /**
     * 出队
     * @return 队头元素
     * @throws Exception
     */
    public int dequeue() throws Exception {
        if (isEmpty()) {
            throw new Exception("队列为空！");
        }
        return queue[++front]; // 注意这里front先自增再引用
    }

    /**
     * 获取队头元素
     */
    public int getHeadElement() throws Exception {
        if (isEmpty()) {
            throw new Exception("队列为空！");
        }
        return queue[front + 1];
    }

    /**
     * 获取队尾元素
     */
    public int getRearElement() throws Exception {
        if (isEmpty()) {
            throw new Exception("队列为空！");
        }
        return queue[rear];
    }

    /**
     * 打印队列
     */
    public void print() {
        if (isEmpty()) {
            System.out.println("无法打印，队列为空！");
            return;
        }
        System.out.print("[front] ");
        for (int i = front + 1; i <= rear; i++) {
            if (i == rear) {
                System.out.println(String.format("[%d (rear)]", queue[i]));
            } else {
                System.out.print(String.format("[%d] ", queue[i]));
            }
        }
    }
}
