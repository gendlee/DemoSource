package chap7.dp;


/**
 * 最短编辑距离：俄罗斯科学家Levenshtein发明，因此也叫Levenshtein距离。
 */
public class Levenshtein {
    public static int levenshteinDistance(String s1, String s2) throws IllegalArgumentException {
        if (s1 == null || s2 == null) {
            throw new IllegalArgumentException("入参不能为null");
        }
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        // 初始化左边界
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        // 初始化上边界
        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <=m; j++) {
                if (i == j && s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]);
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                }
            }
        }
        // 打印dp数组
        LeastEnergyCost.printMatrix(dp, n+1, m+1);
        return dp[n][m];
    }

    public static void main(String[] args) {
        String s1 = "ACTGCAGT-A";
        String s2 = "AC--CAGTTA";
        System.out.println("s1和s2的最小编辑为：" + levenshteinDistance(s1, s2));
    }
}
