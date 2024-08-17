package chap5.linkedList;

/**
 * 单链表类
 */
public class LinkedList {
    private Node head; // 头指针

    /**
     * 创建链表
     * @param array 数组元素
     */
    public void create(int[] array) throws Exception {
        if (null == array || 0 == array.length) {
            throw new Exception("数组元素不存在无法创建链表！");
        }

        head = new Node(array[0]); // 头节点
        Node cur = head;  // 游标

        for (int i = 1; i < array.length; i++) {
            Node node = new Node(array[i]);  // 新建节点
            cur.setNext(node);  // 游标后继节点为当前节点
            cur = node; // 更新游标为当前节点
        }
    }

    /**
     * 计算链表长度
     * @return 长度或元素个数
     */
    public int length() {
        Node cur = head;
        int cnt = 0;
        while (cur != null) {
            cnt++;
            cur = cur.getNext();
        }
        return cnt;
    }

    /**
     * 插入新节点
     * @param index 新增为第几个节点，从1开始
     * @param val   元素值
     */
    public void insert(int index, int val) throws IllegalArgumentException {
        int length = length();
        if (index > length) {
            throw new IllegalArgumentException("索引超限！");
        }
        if (1 == index || index == length + 1) {
            throw new IllegalArgumentException("不支持头部和尾部增加节点，请使用指定的方法！");
        }

        Node cur = head;  // 定义游标
        // 找到第 index - 1 个节点指针
        for (int i = 1; i < index - 1; i++) {
            cur = cur.getNext();
        }
        Node node = new Node(val);  // 新建插入节点
        Node temp = cur.getNext();  // 临时保存cur的后继节点
        cur.setNext(node);  // 将cur的后继节点改为node
        node.setNext(temp);  // 将node的后继节点设置为临时保存的节点
    }

    /**
     * 头部插入新节点
     * @param val 元素值
     */
    public void insertAtHead(int val) {
        Node node = new Node(val);
        node.setNext(head);
        head = node;
    }

    /**
     * 尾部插入新节点
     * @param val 元素值
     */
    public void insertAtTail(int val) {
        Node cur = head;
        if (null == cur) {
            return;
        }
        // 将cur移动到最后一个节点
        while (cur.getNext() != null) {
            cur = cur.getNext();
        }

        Node node = new Node(val);
        cur.setNext(node);
    }

    /**
     * 删除中间指定位置的节点
     * @param index 删除第几个节点，从1开始
     */
    public void remove(int index) throws IllegalArgumentException {
        int length = length();
        if (1 == index || index == length) {
            throw new IllegalArgumentException("不支持头部和尾部节点的删除，请使用指定的方法！");
        }
        Node cur = head;
        int cnt = 1;  // 节点计数器，head为一个节点，所以初始化为1
        while (cnt < (index - 1)) {
            cur = cur.getNext();
            cnt++;
        }
        // 改变指向关系
        cur.setNext(cur.getNext().getNext());
    }

    /**
     * 删除头部节点
     */
    public void removeAtHead() {
        if (null == head) {
            return;
        }
        head = head.getNext();
    }

    /**
     * 删除尾部节点
     */
    public void removeAtTail() {
        if (null == head) {
            return;
        }
        Node cur = head;
        while (cur.getNext().getNext() != null) {
            cur = cur.getNext();
        }
        cur.setNext(null);
    }

    /**
     * 修改指定位置节点的元素值
     * @param index 第几个节点，从1开始
     * @param val   预期修改后的元素值
     */
    public void modify(int index, int val) {
        if (null == head) {
            return;
        }
        Node cur = head;
        int cnt = 1;
        while (cnt < index) {
            cur = cur.getNext();
            cnt++;
        }
        cur.setValue(val);
    }

    /**
     * 打印链表
     */
    public void print() {
        Node cur = head;
        while (cur != null) {
            System.out.print("[ " + cur.getValue() + " ]——>");
            cur = cur.getNext();
        }

        System.out.println("NULL");
    }

    /**
     * 查找目标元素
     * @param target 目标元素值
     * @return 元素所在节点的引用（指针）
     */
    public Node find(int target) {
        if (null == head) {
            return null;
        }
        Node cur = head;
        while (cur != null) {
            if (cur.getValue() == target) {
                return cur;
            }
            cur = cur.getNext();
        }
        return null;
    }


    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }
}
