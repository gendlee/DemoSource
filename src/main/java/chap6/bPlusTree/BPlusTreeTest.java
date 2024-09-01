package chap6.bPlusTree;

public class BPlusTreeTest {
    public static void main(String[] args) {
        // 创建一颗度为3的树
        BPlusTree<Integer, String> bPlusTree = new BPlusTree(3);

        // 插入
        bPlusTree.insert(10, "Value10");
        bPlusTree.insert(20, "Value20");
        bPlusTree.insert(5, "Value5");
        bPlusTree.insert(6, "Value6");
        bPlusTree.insert(12, "Value12");
        bPlusTree.insert(30, "Value30");
        bPlusTree.insert(7, "Value7");
        bPlusTree.insert(17, "Value17");
        // 打印
        bPlusTree.printTree();

        // 删除
        bPlusTree.delete(6);
        bPlusTree.delete(10);

        // 打印
        System.out.println("删除后：");
        bPlusTree.printTree();
    }
}
