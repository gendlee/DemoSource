package chap7.dijkstra;

import java.util.*;
/**
 * Dijkstra实现类
 */
class Dijkstra {

    // 图的表示：邻接表
    private Map<Integer, List<Node>> adjList;

    public Dijkstra() {
        adjList = new HashMap<>();
    }

    // 添加边
    public void addEdge(int source, int destination, int weight) {
        adjList.computeIfAbsent(source, k -> new ArrayList<>()).add(new Node(destination, weight));
        adjList.computeIfAbsent(destination, k -> new ArrayList<>()).add(new Node(source, weight));
    }

    // Dijkstra算法的实现
    public Map<Integer, Integer> dijkstra(int start) {
        // 存储从start到其他节点的最短距离
        Map<Integer, Integer> distances = new HashMap<>();
        // 存储每个节点的前驱节点，用于追溯路径
        Map<Integer, Integer> previousNodes = new HashMap<>();
        // 存储已访问的节点
        Set<Integer> visited = new HashSet<>();
        // 最小优先队列，用于存储当前可以访问的最短路径节点
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.distance));

        // 初始化：将起点放入优先队列，距离设为0
        pq.add(new Node(start, 0));
        distances.put(start, 0);
        previousNodes.put(start, -1); // 起点没有前驱节点

        // 开始Dijkstra算法
        while (!pq.isEmpty()) {
            // 取出当前距离最短的节点
            Node currentNode = pq.poll();
            int currentVertex = currentNode.vertex;

            // 如果节点已经被访问过，则跳过
            if (visited.contains(currentVertex)) {
                continue;
            }

            // 标记节点为已访问
            visited.add(currentVertex);

            // 遍历当前节点的邻居
            List<Node> neighbors = adjList.getOrDefault(currentVertex, new ArrayList<>());
            for (Node neighbor : neighbors) {
                int neighborVertex = neighbor.vertex;
                int edgeWeight = neighbor.distance;
                int newDist = distances.get(currentVertex) + edgeWeight;

                // 如果找到更短的路径，更新距离
                if (newDist < distances.getOrDefault(neighborVertex, Integer.MAX_VALUE)) {
                    distances.put(neighborVertex, newDist);
                    pq.add(new Node(neighborVertex, newDist));
                    previousNodes.put(neighborVertex, currentVertex); // 更新前驱节点
                }
            }
        }
        // 输出每个节点的最短路径
        printPaths(start, distances, previousNodes);

        return distances;
    }

    // 打印从起点到每个节点的最短路径
    private void printPaths(int start, Map<Integer, Integer> distances, Map<Integer, Integer> previousNodes) {
        System.out.println(String.format("离节点%d最近距离及路径：", start));

        for (Map.Entry<Integer, Integer> entry : distances.entrySet()) {
            int destination = entry.getKey();
            int distance = entry.getValue();
            List<Integer> path = new ArrayList<>();

            // 从目标节点回溯前驱节点来构建路径
            for (Integer at = destination; at != -1; at = previousNodes.get(at)) {
                path.add(at);
            }
            Collections.reverse(path); // 将路径反转为从起点到目标节点的顺序

            System.out.println("节点 " + destination + ": 最短距离 = " + distance + ", 最短路径 = " + path);
        }
    }
    // 内部类：用于表示图中的节点和权重
    static class Node {
        int vertex;
        int distance;

        Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }
}
