package chap5.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {
    private int vertices; // 图的顶点数
    private List<List<Integer>> adjList; // 邻接表

    // 构造函数，初始化图
    public Graph(int vertices) {
        this.vertices = vertices;
        adjList = new ArrayList(vertices);

        // 为每个顶点初始化邻接表
        for (int i = 0; i < vertices; i++) {
            adjList.add(new LinkedList());
        }
    }

    // 添加无向图的边
    public void addUDGEdge(int source, int destination) {
        adjList.get(source).add(destination);
        adjList.get(destination).add(source);
    }
    // 添加有向图的边
    public void addDAGEdge(int source, int destination) {
        adjList.get(source).add(destination);
    }

    // 深度优先遍历 (DFS)
    public void dfs(int startVertex) {
        boolean[] visited = new boolean[vertices];
        dfsUtil(startVertex, visited);
    }

    // 递归的DFS辅助方法
    private void dfsUtil(int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        for (int adjVertex : adjList.get(vertex)) {
            if (!visited[adjVertex]) {
                dfsUtil(adjVertex, visited);
            }
        }
    }

    // 广度优先遍历 (BFS)
    public void bfs(int startVertex) {
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList();
        visited[startVertex] = true;
        queue.add(startVertex);
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");
            for (int adjVertex : adjList.get(vertex)) {
                if (!visited[adjVertex]) {
                    visited[adjVertex] = true;
                    queue.add(adjVertex);
                }
            }
        }
    }

    // 打印图
    public void printGraph() {
        for (int i = 0; i < vertices; i++) {
            System.out.print("Vertex " + i + ":");
            for (Integer node : adjList.get(i)) {
                System.out.print(" -> " + node);
            }
            System.out.println();
        }
    }

}
