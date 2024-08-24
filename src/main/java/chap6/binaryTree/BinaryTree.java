package chap6.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<T> {
    private TreeNode root;  // 根节点

    /**
     * 插入节点
     * @param value 节点值
     */
    public void insert(T value, int key) {
        root = insertRec(root, value, key);
    }
    // 递归插入节点
    private TreeNode<T> insertRec(TreeNode<T> root, T value, int key) {
        if (root == null) {
            root = new TreeNode(value, key);
            return root;
        }

        // key小的放在左子树
        if (key < root.key) {
            root.left = insertRec(root.left, value, key);
        } else if (key > root.key) {
            // key大的放在右子树
            root.right = insertRec(root.right, value, key);
        }

        return root;
    }
    /**
     * 层序遍历（广度优先搜索BFS）
     */
    public void bfs() {
        System.out.print("层序遍历: ");
        bfs(root);
        System.out.println();
    }
    private void bfs(TreeNode<T> root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode<T>> queue = new LinkedList();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode<T> currentNode = queue.poll();
            System.out.print(currentNode.value + "["+currentNode.key+ "]" +" ");

            // 将左子节点加入队列
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }

            // 将右子节点加入队列
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }
    }

    /**
     * 前序遍历：当前节点-左子树-右子树
     */
    public void preOrder(){
        System.out.print("前序遍历: ");
        preOrder(root);
        System.out.println();
    }
    // 递归前序遍历
    private void preOrder(TreeNode<T> root){
        if (root != null) {
            System.out.print(root.value + "["+root.key+ "]" + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }


    /**
     * 中序遍历：左子树-当前节点-右子树
     */
    public void inOrder() {
        System.out.print("中序遍历: ");
        inOrder(root);
        System.out.println();
    }
    // 递归中序遍历
    private void inOrder(TreeNode<T> root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.value + "["+root.key+ "]" + " ");
            inOrder(root.right);
        }
    }

    /**
     * 后序遍历：左子树-右子树-当前节点
     */
    public void postOrder() {
        System.out.print("后序遍历: ");
        postOrder(root);
        System.out.println();
    }
    // 递归后序遍历
    private void postOrder(TreeNode<T> root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.value + "["+root.key+ "]" + " ");
        }
    }

    public boolean search(int key) {
        return search(root, key) != null;
    }

    // 查找节点
    private TreeNode<T> search(TreeNode<T> root, int key) {
        if (root == null || root.key == key) {
            return root;
        }
        // key小于根节点的key，则去左子树找
        if (key < root.key) {
            return search(root.left, key);
        }
        // key大于根节点的key，则去右子树找
        return search(root.right, key);
    }

    /**
     * 删除节点
     * @param key 待删除节点的key值
     * @return 待删除的节点指针
     */
    public TreeNode deleteNode(int key) {
        return deleteNode(root, key);
    }

    /**
     * 递归删除节点
     */
    private TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        // 如果key小于当前节点的key，去左子树寻找
        if (key < root.key) {
            root.left = deleteNode(root.left, key);
        }
        // 如果key大于当前节点的key，去右子树寻找
        else if (key > root.key) {
            root.right = deleteNode(root.right, key);
        }
        // 找到要删除的节点
        else {
            // 情况1：节点无子节点（叶子节点）
            if (root.left == null && root.right == null) {
                return null;
            }
            // 情况2：节点只有一个子节点
            else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            // 情况3：节点有两个子节点
            else {
                // 找到右子树的最小值节点,填补原来的位置
                TreeNode minNode = findMin(root.right);
                root.value = minNode.value;
                root.key = minNode.key;
                root.right = deleteNode(root.right, minNode.key);
            }
        }
        return root;
    }

    // 辅助方法：找到树的最小值节点
    private TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}



