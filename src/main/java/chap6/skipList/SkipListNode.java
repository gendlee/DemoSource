package chap6.skipList;

public class SkipListNode<T> {
    int key;  // key用于排序
    T value;  // 节点元素值
    SkipListNode[] forward; // 当前节点的下一个节点数组

    // 构造函数
    public SkipListNode(int key, T value) {
        this.key = key;
        this.value = value;
        this.forward = new SkipListNode[2]; // 水平+垂直各一个
    }
}
