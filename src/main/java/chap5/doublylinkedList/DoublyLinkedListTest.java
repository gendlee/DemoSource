package chap5.doublylinkedList;

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
    }
}
