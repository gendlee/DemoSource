package chap5.linkedListQueue;

import chap5.linkedList.LinkedList;
import chap5.linkedList.Node;

/**
 * 单链表实现的队列
 * 复用单链表类 LinkedList 及节点类 Node
 */
public class LinkedListQueue {
    private LinkedList queue; // 单链表队列
    private int maxSize;  // 最大容量
    private Node front;   // 队头指针
    private Node rear;  // 队尾指针
    private int length;  // 元素个数

    // 构造函数
    public LinkedListQueue(int maxSize) {
        this.queue = new LinkedList(); // 新建链表
        queue.setHead(new Node(0)); // 初始化头节点
        this.maxSize = maxSize + 1;  // front节点额外占用一个节点
        this.front = queue.getHead();
        this.rear = queue.getHead();
        this.length = 0;
    }

    /**
     * 判断队列是否已满
     */
    public boolean isFull() {
        return length == (maxSize - 1); // 初始化时maxSize+1，这里需要减1
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
        Node node = new Node(val); // 新建节点
        rear.setNext(node); // rear的next设置为node
        rear = node;  // 更新node为rear
        length++;
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
        int val = front.getNext().getValue();
        front = front.getNext();
        length--;
        return val;
    }

    /**
     * 获取队头元素
     */
    public int getHeadElement() throws Exception {
        if (isEmpty()) {
            throw new Exception("队列为空！");
        }
        return front.getNext().getValue();
    }

    /**
     * 获取队尾元素
     */
    public int getRearElement() throws Exception {
        if (isEmpty()) {
            throw new Exception("队列为空！");
        }
        return rear.getValue();
    }

    /**
     * 打印队列
     */
    public void print() {
        if (isEmpty()) {
            System.out.println("无法打印，队列为空！");
            return;
        }
        System.out.print("[front]——>");
        Node cur = front.getNext();
        while (cur != null) {
            if (cur.getNext() == null) {
                System.out.print(String.format("[%d(rear)]", cur.getValue()));
            } else {
                System.out.print(String.format("[%d]——>", cur.getValue()));
            }
            cur = cur.getNext();
        }
        System.out.println();
    }
}
