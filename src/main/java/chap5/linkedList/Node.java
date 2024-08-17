package chap5.linkedList;

/**
 * 单向链表节点
 */
public class Node {
    private int value; // 元素值
    private Node next; // 指向下一个节点的指针

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node(int value) {
        this.value = value;
        this.next = null;
    }
}
