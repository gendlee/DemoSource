package chap5.bPlusTree;

import java.util.ArrayList;
import java.util.List;

/**
 * B+树节点类
 */
public class BPlusTreeNode<K extends Comparable<K>, V> {
    private List<K> keys;
    private List<V> values; // 叶子节点值
    private List<BPlusTreeNode<K, V>> children;
    private BPlusTreeNode<K, V> next; // 叶子节点next指针
    private boolean isLeaf;

    public BPlusTreeNode(boolean isLeaf) {
        this.isLeaf = isLeaf;
        keys = new ArrayList();
        if (isLeaf) {
            values = new ArrayList();
        } else {
            children = new ArrayList();
        }
    }

    // Getters and setters

    public List<K> getKeys() {
        return keys;
    }

    public List<V> getValues() {
        return values;
    }

    public List<BPlusTreeNode<K, V>> getChildren() {
        return children;
    }

    public BPlusTreeNode<K, V> getNext() {
        return next;
    }

    public void setNext(BPlusTreeNode<K, V> next) {
        this.next = next;
    }

    public boolean isLeaf() {
        return isLeaf;
    }

    public boolean isOverflow(int maxKeys) {
        return keys.size() > maxKeys;
    }

    public boolean isUnderflow(int minKeys) {
        return keys.size() < minKeys;
    }
}
