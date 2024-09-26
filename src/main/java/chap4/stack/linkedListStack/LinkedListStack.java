package chap4.stack.linkedListStack;

import chap4.linkedList.Node;

/**
 * 链式存储结构实现的堆栈
 * 复用单链表的节点类 Node
 */
public class LinkedListStack {
    private int maxSize;  // 堆栈最大容量
    private int size;  // 堆栈元素个数
    private Node top;  // 栈顶指针

    // 构造函数
    public LinkedListStack(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        this.top = null;
    }

    /**
     * 堆栈是否为空
     */
    public boolean isEmpty() {
        return top == null;
    }

    /**
     * 堆栈是否已满
     */
    public boolean isFull() {
        return size == maxSize;
    }

    /**
     * 入栈操作
     * @param val 入栈元素
     * @throws Exception 堆栈已满异常
     */
    public void push(int val) throws Exception {
        if (isFull()) {
            throw new Exception("堆栈已满，不能再入栈！");
        }
        Node node = new Node(val);  // 新建节点
        node.setNext(top);  // node的后驱节点设置为top
        top = node;  // 更新node为栈顶top
        size++;  // 元素个数加一
    }

    /**
     * 出栈操作
     * @return 栈顶元素值
     * @throws Exception 堆栈为空异常
     */
    public int pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("堆栈为空，不能出栈！");
        }
        Node temp = top;  // 临时指针保存top
        top = top.getNext();  // 将top向后移动
        size--;  // 元素个数减一
        return temp.getValue();  // 返回原栈顶元素
    }

    /**
     * 获取栈顶元素
     * @return 栈顶元素值
     * @throws Exception 堆栈为空异常
     */
    public int getTopElement() throws Exception {
        if (isEmpty()) {
            throw new Exception("堆栈为空，不能获取栈顶元素！");
        }
        return top.getValue();
    }

    /**
     * 打印堆栈
     */
    public void print() {
        if (isEmpty()) {
            System.out.println("堆栈为空，无法打印！");
        }
        Node cur = top;
        while (cur != null) {
            if (cur == top && cur.getNext() != null) {
                System.out.print(String.format("[%d(top)]->", cur.getValue()));
            } else if (cur != top && cur.getNext() == null) {
                System.out.print(String.format("[%d(bottom)]", cur.getValue()));
            } else if (cur == top && cur.getNext() == null) {
                System.out.print(String.format("[%d(top|bottom)]", cur.getValue()));
            } else {
                System.out.print(String.format("[%d]->", cur.getValue()));
            }
            cur = cur.getNext();
        }
        System.out.println();
    }
}
