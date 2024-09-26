package chap5.skipList;

public class SkipListTest {
    public static void main(String[] args) {
        SkipList<String> skipList = new SkipList<String>();
        // 新增节点
        skipList.insert(1, "A");
        skipList.insert(2, "B");
        skipList.insert(3, "C");
        skipList.insert(4, "D");
        skipList.insert(5, "E");
        skipList.insert(6, "F");
        skipList.insert(7, "G");
        skipList.print(); //  输出：
        /**
         * 第 0 层: 1 2 3 4 5 6 7
         * 第 1 层: 2 3 5 7
         */

        System.out.println("查询key值7: " + skipList.search(7)); // 输出：查询key值7: G
        // 删除节点
        skipList.delete(7);
        System.out.println("删除key为7的节点后搜索: " + skipList.search(7)); // 输出：删除key为7的节点后搜索: null
        skipList.print(); // 输出：
        /**
         *第 0 层: 1 2 3 4 5 6
         *第 1 层: 2 3 5
         */
    }
}
