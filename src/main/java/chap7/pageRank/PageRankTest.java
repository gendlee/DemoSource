package chap7.pageRank;

import java.util.Arrays;

public class PageRankTest {
    public static void main(String[] args) {
        // 邻接矩阵表示图，假设图有4个节点
        int[][] links = {
                {0, 1, 1, 0}, // 节点 0 链接到 1, 2
                {0, 0, 0, 1}, // 节点 1 链接到 3
                {1, 0, 0, 1}, // 节点 2 链接到 0, 3
                {0, 0, 0, 0}  // 节点 3 没有出链
        };

        double[] ranks = PageRank.computePageRank(links);
        System.out.println("网站[0,1,2,3]的PageRank: \n" + Arrays.toString(ranks));
    }

}
