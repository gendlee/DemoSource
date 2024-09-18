package chap7.kmeans;

public class KMeansTest {
    public static void main(String[] args) {
        double[][] data = {
                {1.0, 2.0},
                {1.5, 1.8},
                {5.0, 8.0},
                {8.0, 8.0},
                {1.0, 0.6},
                {9.0, 11.0},
                {8.0, 2.0},
                {10.0, 2.0},
                {9.0, 3.0}
        };
        int K = 3;
        KMeans kMeans = new KMeans();
        kMeans.fit(data, K);
    }
}
