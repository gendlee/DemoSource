package chap5.binaryTree;

public class BinaryTreeTest {
    public static void main(String[] args) {
        // 创建一个String类型的二叉树
        BinaryTree<String> tree = new BinaryTree();

        // 插入节点
        tree.insert("A",50);
        tree.insert("B",30);
        tree.insert("C",20);
        tree.insert("D",40);
        tree.insert("E",70);
        tree.insert("F",60);
        tree.insert("G",80);
        /**
         * 当前树的形状：
         *            A[50]
         *         /       \
         *      B[30]      E[70]
         *      /   \     /    \
         *  C[20]  D[40] F[60] G[80]
         */

        // 遍历二叉树
        tree.bfs();       // 输出: 层序遍历: A[50] B[30] E[70] C[20] D[40] F[60] G[80]
        tree.preOrder();  // 输出: 前序遍历: A[50] B[30] C[20] D[40] E[70] F[60] G[80]
        tree.inOrder();   // 输出: 中序遍历: C[20] B[30] D[40] A[50] F[60] E[70] G[80]
        tree.postOrder(); // 输出: 后序遍历: C[20] D[40] B[30] F[60] G[80] E[70] A[50]

        // 查找节点
        System.out.println("查找F(60): " + tree.search(60)); // 输出: 查找60: true
        System.out.println("查找key 100: " + tree.search(90)); // 查找key 100: false

        tree.deleteNode(70);  // 删除E[70]
        /**
         * 当前树的形状：
         *            A[50]
         *         /       \
         *      B[30]      G[80]
         *      /   \       /
         *  C[20]  D[40] F[60]
         */

        tree.bfs();        // 输出: 层序遍历: A[50] B[30] G[80] C[20] D[40] F[60]
        tree.preOrder();   // 输出: 前序遍历: A[50] B[30] C[20] D[40] G[80] F[60]
        tree.inOrder();    // 输出: 中序遍历: C[20] B[30] D[40] A[50] F[60] G[80]
        tree.postOrder();  // 输出: 后序遍历: C[20] D[40] B[30] F[60] G[80] A[50]
    }
}
