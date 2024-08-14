package chap5.doublylinkedList;

public class DoublyLinkedList {
    private DNode head;  // 头指针
    private DNode tail;  // 尾指针
    private int length;  // 节点个数，增加和删除节点时维护之


    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    /**
     * 创建双向链表
     * @param array 输入数组
     */
    public void create(int[] array) {
        if (null == array || 0 == array.length) {
            return;
        }
        length = array.length;  // 链表节点数目
        head = new DNode(array[0]);  // 先创建头节点
        tail = head;  // 初始化尾节点
        for (int i = 1; i < array.length; i++) {
            DNode node = new DNode(array[i]);  // 新建节点
            tail.setNext(node);  // 新节点为tail的后继节点
            node.setPrev(tail); // 新节点前驱为tail
            tail = node;  // 更新尾指针
            if (1 == i) {
                head.setNext(node);
                node.setPrev(head);
            }
        }
    }

    /**
     * 中间插入节点
     * @param index 第几个节点，从1开始
     * @param val 节点值
     */
    public void insert(int index, int val) throws IllegalArgumentException {
        if (index > (length + 1) || index < 0) {
            throw new IllegalArgumentException("超出操作范围，当前链表长度：" + length);
        }
        if (1 == index || index == (length + 1)) {
            throw new IllegalArgumentException("不支持头部和尾部插入节点，请使用对应的方法！");
        }

        DNode cur = head;
        // 找到第index - 1个节点
        for (int i = 1; i < index - 1; i++) {
            cur = cur.getNext();
        }
        DNode node = new DNode(val);  // 新建节点
        DNode temp = cur.getNext();  // 保存cur的next节点
        cur.setNext(node);  // cur的next设置为node
        node.setNext(temp);  // node的next设置为temp
        node.setPrev(cur);  // node的prev设置为cur
        temp.setPrev(node);  // temp的prev设置为node

        length++; // 更新链表长度
    }

    /**
     * 头部插入节点
     * @param val
     */
    public void insertAtHead(int val) {
        if (head == null) {
            return;
        }
        DNode node = new DNode(val); // 新建节点
        head.setPrev(node);  // head的前驱节点设置为node
        node.setNext(head);  // node的后继节点设置为head
        head = node;         // 更新链表的head节点为node
        length++; // 更新链表长度
    }

    /**
     * 尾部插入节点
     * @param val
     */
    public void insertAtTail(int val) {
        if (tail == null) {
            return;
        }
        DNode node = new DNode(val); // 新建节点
        tail.setNext(node);  // tail的后继节点为node
        node.setPrev(tail);  // node的前驱节点为tail
        tail = node;  // 更新tail为node
        length++;  // 更新链表长度
    }


    /**
     * 删除中间节点
     * @param target 待删除的节点目标值
     */
    public void remove(int target) throws IllegalArgumentException {
        if (head == null) {
            return;
        }
        DNode cur = head;
        // 寻找目标节点
        while (cur != null && cur.getValue() != target) {
            cur = cur.getNext();
        }

        if (cur == null) {
            return; // 未找到目标值节点
        }
        if (cur.getNext() == null || cur.getPrev() == null) {
            throw new IllegalArgumentException("不支持删除头部和尾部节点，请使用对应的方法！");
        }
        DNode temp = cur.getPrev();  // temp为cur的前驱节点
        temp.setNext(cur.getNext()); // temp的后继节点设为cur的后继节点
        cur.getNext().setPrev(temp); // cur的后继节点的前驱节点设置为temp
        length--; // 更新链表长度
    }

    /**
     * 删除头部节点
     */
    public void removeAtHead() {
        if (head == null) {
            return;
        }
        head = head.getNext();
        head.setPrev(null);
        length--;
    }

    /**
     * 删除尾部节点
     */
    public void removeAtTail() {
        if (tail == null) {
            return;
        }
        DNode temp = tail.getPrev();  // 保存tail的前驱节点
        temp.setNext(null);  // temp无后继节点，即最后一个节点
        tail.setPrev(null);  // tail去掉前驱节点
        tail = temp; // 更新尾节点为temp
        length--;
    }

    /**
     * 打印双向链表
     */
    public void print() {
        DNode cur = head;
        while (cur != null) {
            if (cur.getNext() != null) {
                System.out.print("[ " + cur.getValue() + " ]⇆");
            } else {
                System.out.print("[ " + cur.getValue() + " ]—>");
            }

            cur = cur.getNext();
        }

        System.out.println("NULL");
    }

}
