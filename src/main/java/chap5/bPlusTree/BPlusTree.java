package chap5.bPlusTree;

import java.util.Collections;
/**
 * B+树的操作类
 */
public class BPlusTree<K extends Comparable<K>, V> {
    private BPlusTreeNode<K, V> root;
    private int maxKeys; // 节点最多key
    private int minKeys; // 节点最少key

    public BPlusTree(int degree) {
        this.maxKeys = degree - 1;
        this.minKeys = (degree + 1) / 2 - 1;
        this.root = new BPlusTreeNode(true);
    }

    // 插入节点
    public void insert(K key, V value) {
        BPlusTreeNode<K, V> r = root;
        if (r.isOverflow(maxKeys)) {
            BPlusTreeNode<K, V> s = new BPlusTreeNode(false);
            root = s;
            s.getChildren().add(r);
            splitChild(s, 0, r);
            insertNonFull(s, key, value);
        } else {
            insertNonFull(r, key, value);
        }
    }

    private void insertNonFull(BPlusTreeNode<K, V> node, K key, V value) {
        int i = node.getKeys().size() - 1;

        if (node.isLeaf()) {
            while (i >= 0 && key.compareTo(node.getKeys().get(i)) < 0) {
                i--;
            }
            node.getKeys().add(i + 1, key);
            node.getValues().add(i + 1, value);
        } else {
            while (i >= 0 && key.compareTo(node.getKeys().get(i)) < 0) {
                i--;
            }
            i++;
            BPlusTreeNode<K, V> child = node.getChildren().get(i);
            if (child.isOverflow(maxKeys)) {
                splitChild(node, i, child);
                if (key.compareTo(node.getKeys().get(i)) > 0) {
                    i++;
                }
            }
            insertNonFull(node.getChildren().get(i), key, value);
        }
    }

    // 分裂节点
    private void splitChild(BPlusTreeNode<K, V> parent, int index, BPlusTreeNode<K, V> child) {
        int midIndex = maxKeys / 2;
        BPlusTreeNode<K, V> newNode = new BPlusTreeNode(child.isLeaf());

        parent.getKeys().add(index, child.getKeys().get(midIndex));
        parent.getChildren().add(index + 1, newNode);

        newNode.getKeys().addAll(child.getKeys().subList(midIndex + 1, child.getKeys().size()));
        child.getKeys().subList(midIndex, child.getKeys().size()).clear();

        if (child.isLeaf()) {
            newNode.getValues().addAll(child.getValues().subList(midIndex + 1, child.getValues().size()));
            child.getValues().subList(midIndex + 1, child.getValues().size()).clear();

            newNode.setNext(child.getNext());
            child.setNext(newNode);
        } else {
            newNode.getChildren().addAll(child.getChildren().subList(midIndex + 1, child.getChildren().size()));
            child.getChildren().subList(midIndex + 1, child.getChildren().size()).clear();
        }
    }

    // 删除Key
    public void delete(K key) {
        delete(root, key);
        if (!root.isLeaf() && root.getKeys().isEmpty()) {
            root = root.getChildren().get(0);
        }
    }

    private void delete(BPlusTreeNode<K, V> node, K key) {
        int idx = Collections.binarySearch(node.getKeys(), key);

        if (node.isLeaf()) {
            if (idx >= 0) {
                node.getKeys().remove(idx);
                node.getValues().remove(idx);
            }
            return;
        }

        if (idx >= 0) {
            BPlusTreeNode<K, V> predChild = node.getChildren().get(idx);
            if (predChild.getKeys().size() > minKeys) {
                K predKey = getPredecessor(predChild);
                delete(predChild, predKey);
                node.getKeys().set(idx, predKey);
            } else {
                BPlusTreeNode<K, V> succChild = node.getChildren().get(idx + 1);
                if (succChild.getKeys().size() > minKeys) {
                    K succKey = getSuccessor(succChild);
                    delete(succChild, succKey);
                    node.getKeys().set(idx, succKey);
                } else {
                    mergeChildren(node, idx);
                    delete(predChild, key);
                }
            }
        } else {
            idx = -idx - 1;
            BPlusTreeNode<K, V> child = node.getChildren().get(idx);
            if (child.getKeys().size() <= minKeys) {
                BPlusTreeNode<K, V> leftSibling = idx > 0 ? node.getChildren().get(idx - 1) : null;
                BPlusTreeNode<K, V> rightSibling = idx < node.getChildren().size() - 1 ? node.getChildren().get(idx + 1) : null;

                if (leftSibling != null && leftSibling.getKeys().size() > minKeys) {
                    child.getKeys().add(0, node.getKeys().get(idx - 1));
                    node.getKeys().set(idx - 1, leftSibling.getKeys().remove(leftSibling.getKeys().size() - 1));

                    if (!child.isLeaf()) {
                        child.getChildren().add(0, leftSibling.getChildren().remove(leftSibling.getChildren().size() - 1));
                    }
                } else if (rightSibling != null && rightSibling.getKeys().size() > minKeys) {
                    child.getKeys().add(node.getKeys().get(idx));
                    node.getKeys().set(idx, rightSibling.getKeys().remove(0));

                    if (!child.isLeaf()) {
                        child.getChildren().add(rightSibling.getChildren().remove(0));
                    }
                } else {
                    if (leftSibling != null) {
                        mergeChildren(node, idx - 1);
                        child = leftSibling;
                    } else {
                        mergeChildren(node, idx);
                    }
                }
            }
            delete(child, key);
        }
    }

    // 合并节点
    private void mergeChildren(BPlusTreeNode<K, V> parent, int index) {
        BPlusTreeNode<K, V> leftChild = parent.getChildren().get(index);
        BPlusTreeNode<K, V> rightChild = parent.getChildren().remove(index + 1);

        leftChild.getKeys().add(parent.getKeys().remove(index));
        leftChild.getKeys().addAll(rightChild.getKeys());

        if (!leftChild.isLeaf()) {
            leftChild.getChildren().addAll(rightChild.getChildren());
        } else {
            leftChild.setNext(rightChild.getNext());
        }
    }

    // 获取前序节点
    private K getPredecessor(BPlusTreeNode<K, V> node) {
        while (!node.isLeaf()) {
            node = node.getChildren().get(node.getChildren().size() - 1);
        }
        return node.getKeys().get(node.getKeys().size() - 1);
    }
    // 获取后继节点
    private K getSuccessor(BPlusTreeNode<K, V> node) {
        while (!node.isLeaf()) {
            node = node.getChildren().get(0);
        }
        return node.getKeys().get(0);
    }

    public void printTree() {
        if (root == null) {
            System.out.println("The tree is empty.");
            return;
        }
        printNode(root, 0);
    }

    private void printNode(BPlusTreeNode<K, V> node, int level) {
        System.out.print("第 " + (level+1) + " 层： ");
        for (K key : node.getKeys()) {
            System.out.print(key + " ");
        }
        System.out.println();

        if (!node.isLeaf()) {
            for (BPlusTreeNode<K, V> child : node.getChildren()) {
                printNode(child, level + 1);
            }
        }
    }
}
