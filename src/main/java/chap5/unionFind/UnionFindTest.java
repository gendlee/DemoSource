package chap5.unionFind;

public class UnionFindTest {
    public static void main(String[] args) {
        int size = 6; // 6个集合编号，0~5
        UnionFind unionFind = new UnionFind(size);

        unionFind.union(1,3);  // 将1和3合并
        unionFind.union(3,5);  // 将3和5合并，则构成集合{1，3，5}
        unionFind.printRelationsBetween(1, 5); // 输出：1和5是连通的，属于同一个集合

        unionFind.printRelationsBetween(1, 2); // 输出：1和2不连通，属于不同集合
        unionFind.union(1,2);  // 将1和2合并
        unionFind.printRelationsBetween(1, 2); // 输出：1和2是连通的，属于同一个集合
    }
}
