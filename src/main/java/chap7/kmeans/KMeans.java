package chap7.kmeans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class KMeans {

    // 初始化K个质心
    private double[][] initializeCentroids(double[][] data, int K) {
        Random random = new Random();
        double[][] centroids = new double[K][data[0].length];
        List<Integer> usedIndices = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            int index;
            do {
                index = random.nextInt(data.length);
            } while (usedIndices.contains(index));
            usedIndices.add(index);
            centroids[i] = Arrays.copyOf(data[index], data[index].length);
        }
        return centroids;
    }

    // 查找最近的质心
    private int findClosestCentroid(double[] point, double[][] centroids) {
        int closestIndex = 0;
        double minDistance = Double.MAX_VALUE;
        for (int i = 0; i < centroids.length; i++) {
            double distance = euclideanDistance(point, centroids[i]);
            if (distance < minDistance) {
                minDistance = distance;
                closestIndex = i;
            }
        }
        return closestIndex;
    }

    // 计算欧氏距离
    private double euclideanDistance(double[] point1, double[] point2) {
        double sum = 0;
        for (int i = 0; i < point1.length; i++) {
            double diff = point1[i] - point2[i];
            sum += diff * diff;
        }
        return Math.sqrt(sum);
    }

    // 运行K-means算法，迭代更新质心直到收敛或达到最大迭代次数
    public void fit(double[][] data, int K) {
        int n = data.length;
        int m = data[0].length;
        double[][] centroids = initializeCentroids(data, K);
        int[] labels = new int[n];
        boolean converged = false;

        for (int iteration = 0; iteration < 100; iteration++) {
            // Step 1: 将最近的质心分配给每个数据点
            for (int i = 0; i < n; i++) {
                labels[i] = findClosestCentroid(data[i], centroids);
            }

            // Step 2: 计算新的质心
            double[][] newCentroids = new double[K][m];
            int[] counts = new int[K];
            for (int i = 0; i < n; i++) {
                int cluster = labels[i];
                for (int j = 0; j < m; j++) {
                    newCentroids[cluster][j] += data[i][j];
                }
                counts[cluster]++;
            }
            for (int i = 0; i < K; i++) {
                for (int j = 0; j < m; j++) {
                    if (counts[i] > 0) {
                        newCentroids[i][j] /= counts[i];
                    }
                }
            }

            // 检查是否收敛
            converged = true;
            for (int i = 0; i < K; i++) {
                // 假设质心偏移收敛在0.0001以内则终止迭代
                if (euclideanDistance(centroids[i], newCentroids[i]) > 1e-4) {
                    converged = false;
                    break;
                }
            }
            centroids = newCentroids;

            if (converged) {
                break;
            }
        }

        // 打印结果
        System.out.println("质心坐标:");
        for (double[] centroid : centroids) {
            System.out.println(Arrays.toString(centroid));
        }
    }
}
