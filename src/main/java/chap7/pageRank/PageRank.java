package chap7.pageRank;

import java.util.Arrays;

public class PageRank {
    private static final double DAMPING_FACTOR = 0.85;  // 阻尼系数
    private static final int MAX_ITERATIONS = 100;      // 最大迭代次数
    private static final double TOLERANCE = 1e-6;       // 收敛阈值
    public static double[] computePageRank(int[][] links) {
        int n = links.length;  // 节点数量
        double[] ranks = new double[n];  // 每个节点的初始 PageRank 值
        Arrays.fill(ranks, 1.0 / n);  // 初始每个节点的 PageRank 为 1/N

        double[] newRanks = new double[n];

        for (int iteration = 0; iteration < MAX_ITERATIONS; iteration++) {
            Arrays.fill(newRanks, (1 - DAMPING_FACTOR) / n);  // 初始值 (1 - d)/N

            // 计算新的 PageRank 值
            for (int i = 0; i < n; i++) {
                int outLinks = 0;
                for (int j = 0; j < n; j++) {
                    if (links[i][j] == 1) {
                        outLinks++;
                    }
                }
                if (outLinks == 0) {
                    // 如果当前节点没有出链，PageRank 平均分配给其他所有节点
                    for (int j = 0; j < n; j++) {
                        newRanks[j] += DAMPING_FACTOR * (ranks[i] / n);
                    }
                } else {
                    // 如果有出链，将PageRank按照出链分配给连接到的节点
                    for (int j = 0; j < n; j++) {
                        if (links[i][j] == 1) {
                            newRanks[j] += DAMPING_FACTOR * (ranks[i] / outLinks);
                        }
                    }
                }
            }

            // 检查是否收敛
            if (hasConverged(ranks, newRanks)) {
                break;
            }

            System.arraycopy(newRanks, 0, ranks, 0, n);  // 更新 ranks
        }

        return ranks;
    }

    private static boolean hasConverged(double[] oldRanks, double[] newRanks) {
        for (int i = 0; i < oldRanks.length; i++) {
            if (Math.abs(oldRanks[i] - newRanks[i]) > TOLERANCE) {
                return false;
            }
        }
        return true;
    }
}
