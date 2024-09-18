package chap7.dijkstra;

import java.util.*;

/**
 * 测试类
 */
class DijkstraTest {

    public static void main(String[] args) {
        Dijkstra graph = new Dijkstra();

        // 添加图中的边 (节点1, 节点2, 权重)
        graph.addEdge(0, 2, 4);
        graph.addEdge(0, 4, 2);
        graph.addEdge(1, 2, 3);
        graph.addEdge(1, 3, 3);
        graph.addEdge(1, 4, 7);
        graph.addEdge(2, 4, 1);
        graph.addEdge(3, 4, 5);
        
        // 从起点0计算最短路径
        Map<Integer, Integer> distances = graph.dijkstra(0);

    }
}
