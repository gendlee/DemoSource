package chap5.doublyLinkedList;

/**
 * 双向链表节点
 */
public class DNode {
    private int value; // 元素值
    private DNode next; // 指向下一个节点的指针
    private DNode prev; // 指向前一个节点的指针

    public DNode(int value) {
        this.value = value;
        this.next = null;
        this.prev = null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public DNode getNext() {
        return next;
    }

    public void setNext(DNode next) {
        this.next = next;
    }

    public DNode getPrev() {
        return prev;
    }

    public void setPrev(DNode prev) {
        this.prev = prev;
    }
}
