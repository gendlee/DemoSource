package chap6.skipList;

public class SkipList<T> {
    private static final int MAX_LEVEL = 16; // 设定最大层级
    private int level;  // 当前跳表的层级
    private SkipListNode<T> head; // 头节点指针

    // 构造函数
    public SkipList() {
        this.level = 0;
        this.head = new SkipListNode<T>(Integer.MIN_VALUE, null);
    }

    // 插入
    public void insert(int key, T value) {
        SkipListNode<T> newNode = new SkipListNode(key, value);

        // 在第0层找到插入位置
        SkipListNode<T> x = head;
        SkipListNode<T>[] update = new SkipListNode[MAX_LEVEL];

        for (int i = level; i >= 0; i--) {
            while (x.forward[i] != null && x.forward[i].key < key) {
                x = x.forward[i];
            }
            update[i] = x;
        }

        x = x.forward[0];
        if (x != null && x.key == key) {
            x.value = value; // 如果节点已存在，更新值
            return;
        }

        // 插入到第0层
        x = update[0];
        newNode.forward[0] = x.forward[0];
        x.forward[0] = newNode;

        // 更新每一层的索引
        int currentLevel = 0;
        for (int i = 1; i <= level; i++) {
            SkipListNode<T> prev = head;
            SkipListNode<T> curr = head.forward[i-1];
            int count = 0;
            while (curr != null) {
                if (count % 2 == 0) {
                    prev.forward[i] = curr;
                    prev = curr;
                }
                curr = curr.forward[i-1];
                count++;
            }
            prev.forward[i] = null; // 末尾节点置为null

            // 如果某一层的节点数少于2，则停止增加层数
            if (count < 2) {
                break;
            }
            currentLevel = i;
        }

        // 更新当前层数
        level = Math.min(currentLevel, MAX_LEVEL - 1);
    }

    // 删除
    public void delete(int key) {
        SkipListNode<T>[] update = new SkipListNode[MAX_LEVEL];
        SkipListNode<T> x = head;

        // 从顶层开始搜索
        for (int i = level; i >= 0; i--) {
            while (x.forward[i] != null && x.forward[i].key < key) {
                x = x.forward[i];
            }
            update[i] = x;
        }

        x = x.forward[0];
        if (x != null && x.key == key) {
            for (int i = 0; i <= level; i++) {
                if (update[i].forward[i] != x) break;
                update[i].forward[i] = x.forward[i];
            }

            // 检查是否需要减少跳表的层级
            while (level > 0 && head.forward[level] == null) {
                level--;
            }
        }
    }

    // 搜索
    public T search(int key) {
        SkipListNode<T> x = head;
        for (int i = level; i >= 0; i--) {
            while (x.forward[i] != null && x.forward[i].key < key) {
                x = x.forward[i];
            }
        }
        x = x.forward[0];
        if (x != null && x.key == key) {
            return x.value;
        }
        return null;
    }

    // 打印
    public void print() {
        for (int i = 0; i <= level; i++) {
            SkipListNode<T> node = head.forward[i];
            System.out.print("第 " + i + " 层: ");
            while (node != null) {
                System.out.print(node.key + " ");
                node = node.forward[i];
            }
            System.out.println();
        }
    }
}