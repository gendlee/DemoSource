package chap6.binaryTree;

public class TreeNode<T> {
    T value; // 节点值
    TreeNode left;  // 左子节点
    TreeNode right; // 右子节点

    public TreeNode(T value) {
        this.value = value; // 设置节点值
        this.left = null;  // 左子树为空
        this.right = null; // 右子树为空
    }
}
