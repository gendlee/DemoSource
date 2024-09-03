package chap7;

public class ZeroOneBag {

    public static int findMaxValue(int[] w, int[] v, int maxWeight) {
        int n = w.length;
        if (n == 0) {
            // 没有物品，价值为0
            return 0;
        }
        int[] dp = new int[maxWeight + 1];
        dp[0] = 0;  // 初始条件
        for (int i = 1; i <= n; i++) {
            for (int j = maxWeight; j > 0; j--) {
                if (w[i - 1] <= j) {
                    dp[j] = Math.max(dp[j], dp[j - w[i - 1]] + v[i - 1]);
                }
            }
        }
        return dp[maxWeight];
    }

    public static void main(String[] args) {
        int[] w = new int[]{5, 10, 20, 15};
        int[] v = new int[]{20, 40, 60, 50};
        int maxWeight = 35;

        System.out.print(findMaxValue(w, v, maxWeight));
    }
}
