package chap5.linkedlist;

public class LinkedListTest {
    public static void main(String[] args) throws Exception {
        LinkedList linkedList = new LinkedList();
        int[] array = new int[]{-1, 5, 8, 4};
        // 1、创建链表
        linkedList.create(array);
        linkedList.print();  // 输出：[ -1 ]——>[ 5 ]——>[ 8 ]——>[ 4 ]——>NULL

        // 2、中间插入节点：第3个节点处插入节点值9
        linkedList.insert(3, 9);
        linkedList.print();  // 输出：[ -1 ]——>[ 5 ]——>[ 9 ]——>[ 8 ]——>[ 4 ]——>NULL

        // 3、头部插入节点：节点值-2
        linkedList.insertAtHead(-2);
        linkedList.print();  // 输出：[ -2 ]——>[ -1 ]——>[ 5 ]——>[ 9 ]——>[ 8 ]——>[ 4 ]——>NULL

        // 4、尾部插入节点：节点值6
        linkedList.insertAtTail(6);
        linkedList.print();  // 输出：[ -2 ]——>[ -1 ]——>[ 5 ]——>[ 9 ]——>[ 8 ]——>[ 4 ]——>[ 6 ]——>NULL

        // 5、删除第3个节点，值为5
        linkedList.remove(3);
        linkedList.print();  // 输出：[ -2 ]——>[ -1 ]——>[ 9 ]——>[ 8 ]——>[ 4 ]——>[ 6 ]——>NULL

        // 6、删除头部节点
        linkedList.removeAtHead();
        linkedList.print();  // 输出：[ -1 ]——>[ 9 ]——>[ 8 ]——>[ 4 ]——>[ 6 ]——>NULL


        // 7、删除尾部节点
        linkedList.removeAtTail();
        linkedList.print();  // 输出：[ -1 ]——>[ 9 ]——>[ 8 ]——>[ 4 ]——>NULL

        // 8、修改第2个节点的元素：9 -> 3
        linkedList.modify(2, 3);
        linkedList.print();  // 输出：[ -1 ]——>[ 3 ]——>[ 8 ]——>[ 4 ]——>NULL

        // 9、查找元素3
        Node foundNode = linkedList.find(3);
        System.out.print(null != foundNode ? "已找到：" + foundNode.getValue() : "未找到！");

    }
}
