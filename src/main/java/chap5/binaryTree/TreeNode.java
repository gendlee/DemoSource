package chap5.binaryTree;

public class TreeNode<T> {
    int key; // 用于比较节点顺序，使得生成的二叉树更加平衡
    T value; // 节点值
    TreeNode left;  // 左子节点
    TreeNode right; // 右子节点

    public TreeNode(T value, int key) {
        this.key = key; // 设置key
        this.value = value; // 设置节点值
        this.left = null;  // 左子树为空
        this.right = null; // 右子树为空
    }
}
