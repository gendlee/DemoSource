package chap6.unionFind;

public class UnionFind {
    private int[] parent;  // 数组定义集合编号
    private int size;  // 集合个数

    // 构造函数
    public UnionFind(int size) {
        this.parent = new int[size];
        this.size = size;
        // 为每个集合分配编号：索引值作为其编号
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    /**
     * 查找元素属于哪个集合：不推荐，未采用路径压缩
     * @param val 元素值
     * @return 集合编号
     */
    @Deprecated
    public int find(int val) {
        while (parent[val] != val) { // 父节点不是自己说明不是根节点
            val = find(parent[val]);  // 继续递归寻找
        }
        return val;
    }

    /**
     * 采用路径压缩方式查找
     * 使用递归，当发现节点的父节点是自己时停止
     * @param val 元素值
     * @return 集合编号
     */
    public int findWithCompression(int val) {
        if (parent[val] != val) {
            parent[val] = findWithCompression(parent[val]);
        }

        return parent[val];
    }

    /**
     * 合并两个元素到同一个集合
     * @param val1
     * @param val2
     */
    public void union(int val1, int val2) {
        int root1 = findWithCompression(val1);  // 查找val1的根节点
        int root2 = findWithCompression(val2);  // 查找val2的根节点
        // 属于不同的集合，可以合并
        if (root1 != root2) {
            parent[root2] = root1;  // 合并：将val2根节点合并到val1的根节点
        }
        // 属于相同的集合，不需要合并
    }

    /**
     * 判断两个元素是否是连通的
     * @param val1
     * @param val2
     * @return 连通与否：true/false
     */
    public boolean isConnected(int val1, int val2) {
        return findWithCompression(val1) == findWithCompression(val2);
    }

    /**
     * 打印两个元素的关系
     */
    public void printRelationsBetween(int val1, int val2) {
        if (isConnected(val1, val2)) {
            System.out.println(String.format("%d和%d是连通的，属于同一个集合", val1, val2));
        } else {
            System.out.println(String.format("%d和%d不连通，属于不同集合", val1, val2));
        }
    }

    public int getSize() {
        return size;
    }
}
