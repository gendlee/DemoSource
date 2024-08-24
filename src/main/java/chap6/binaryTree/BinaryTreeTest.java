package chap6.binaryTree;

public class BinaryTreeTest {
    public static void main(String[] args) {
        // 创建一个Integer类型的二叉树
        BinaryTree<Integer> tree = new BinaryTree();

        // 插入节点
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        // 遍历二叉树
        System.out.print("层序遍历: ");
        tree.bfs();  // 输出: 层序遍历: 50 30 70 20 40 60 80

        System.out.print("前序遍历: ");
        tree.preOrder();  // 输出: 前序遍历: 50 30 20 40 70 60 80

        System.out.print("中序遍历: ");
        tree.inOrder();   // 输出: 中序遍历: 20 30 40 50 60 70 80


        System.out.print("后序遍历: ");
        tree.postOrder(); // 输出: 后序遍历: 20 40 30 60 80 70 50

        // 查找节点
        System.out.println("查找60: " + tree.search(60)); // 输出: 查找60: true
        System.out.println("查找100: " + tree.search(100)); // 查找100: false
    }
}
