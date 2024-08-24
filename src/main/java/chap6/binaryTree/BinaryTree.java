package chap6.binaryTree;

public class BinaryTree<T> {
    private TreeNode root;  // 根节点

    /**
     * 插入节点
     * @param value 节点值
     */
    public void insert(T value) {
        root = insertRec(root, value);
    }
    // 递归插入节点
    private TreeNode<T> insertRec(TreeNode<T> root, T value) {
        if (root == null) {
            root = new TreeNode(value);
            return root;
        }

        // 假设TreeNode的value支持比较操作
        if (((Comparable<T>) value).compareTo(root.value) < 0) {
            root.left = insertRec(root.left, value);
        } else if (((Comparable<T>) value).compareTo(root.value) > 0) {
            root.right = insertRec(root.right, value);
        }

        return root;
    }

    /**
     * 前序遍历：当前节点-左子树-右子树
     */
    public void preOrder(){
        preOrder(root);
    }
    // 递归前序遍历
    private void preOrder(TreeNode<T> root){
        if (root != null) {
            System.out.print(root.value + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }


    /**
     * 中序遍历：左子树-当前节点-右子树
     */
    public void inOrder() {
        inOrder(root);
    }
    // 递归中序遍历
    private void inOrder(TreeNode<T> root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.value + " ");
            inOrder(root.right);
        }
    }

    /**
     * 后序遍历：左子树-右子树-当前节点
     */
    public void postOrder() {
        postOrder(root);
    }
    // 递归后序遍历
    private void postOrder(TreeNode<T> root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.value + " ");
        }
    }

    public boolean search(T value) {
        return search(root, value) != null;
    }

    // 查找节点
    private TreeNode<T> search(TreeNode<T> root, T value) {
        if (root == null || root.value.equals(value)) {
            return root;
        }

        if (((Comparable<T>) value).compareTo(root.value) < 0) {
            return search(root.left, value);
        }

        return search(root.right, value);
    }
}



