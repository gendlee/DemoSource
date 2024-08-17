package chap5.doublyLinkedList;

public class DoublyLinkedListTest {
    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        int[] array = new int[]{-1, 5, 8, 4};

        // 1、创建双向链表
        doublyLinkedList.create(array);
        doublyLinkedList.print(); // 输出：[ -1 ]⇆[ 5 ]⇆[ 8 ]⇆[ 4 ]—>NULL

        // 2、中间插入：第3个节点插入值9
        doublyLinkedList.insert(3, 9);
        doublyLinkedList.print(); // 输出：[ -1 ]⇆[ 5 ]⇆[ 9 ]⇆[ 8 ]⇆[ 4 ]—>NULL

        // 3、头部插入：插入值-2
        doublyLinkedList.insertAtHead(-2);
        doublyLinkedList.print(); // 输出：[ -2 ]⇆[ -1 ]⇆[ 5 ]⇆[ 9 ]⇆[ 8 ]⇆[ 4 ]—>NULL

        // 4、尾部插入：插入值6
        doublyLinkedList.insertAtTail(6);
        doublyLinkedList.print(); // 输出：[ -2 ]⇆[ -1 ]⇆[ 5 ]⇆[ 9 ]⇆[ 8 ]⇆[ 4 ]⇆[ 6 ]—>NULL

        // 5、中间删除：删除目标值9的节点
        doublyLinkedList.remove(9);
        doublyLinkedList.print(); // 输出：[ -2 ]⇆[ -1 ]⇆[ 5 ]⇆[ 8 ]⇆[ 4 ]⇆[ 6 ]—>NULL

        // 6、删除头部节点
        doublyLinkedList.removeAtHead();
        doublyLinkedList.print(); // 输出：[ -1 ]⇆[ 5 ]⇆[ 8 ]⇆[ 4 ]⇆[ 6 ]—>NULL

        // 7、删除尾部节点
        doublyLinkedList.removeAtTail();
        doublyLinkedList.print(); // 输出：[ -1 ]⇆[ 5 ]⇆[ 8 ]⇆[ 4 ]—>NULL

    }
}
