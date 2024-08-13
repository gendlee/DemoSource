package chap5.doublylinkedList;

public class DoublyLinkedListTest {
    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        int[] array = new int[]{-1, 5, 8, 4};

        // 1、创建双向链表
        doublyLinkedList.create(array);
        doublyLinkedList.print(); // 输出：[ -1 ] ⇆ [ 5 ] ⇆ [ 8 ] ⇆ [ 4 ]—>NULL
    }
}
