package chap6.graph;

public class GraphTest {
    public static void main(String[] args) {
        // 创建一个包含5个顶点的图
        Graph graph = new Graph(5);

        // 添加边
        graph.addUDGEdge(0, 1);
        graph.addUDGEdge(0, 4);
        graph.addUDGEdge(1, 2);
        graph.addUDGEdge(1, 3);
        graph.addUDGEdge(1, 4);
        graph.addUDGEdge(2, 3);
        graph.addUDGEdge(3, 4);

        // 打印图
        System.out.println("图:");
        graph.printGraph();

        // 执行深度优先遍历
        System.out.println("DFS遍历 (从顶点 0 开始)：");
        graph.dfs(0);

        System.out.println();
        // 执行广度优先遍历
        System.out.println("BFS遍历 (从顶点 0 开始)：");
        graph.bfs(0);
    }
}
