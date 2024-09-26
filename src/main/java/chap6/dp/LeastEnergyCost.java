package chap6.dp;

public class LeastEnergyCost {

    // 小白兔走宫格：能量消耗最低的走法
    public static int leastEnergyCost(int[][] grid, int n, int m) {
        if (n == 1 && m == 1) {
            return grid[0][0];// 只有一个网格
        }
        int[][] dp = new int[n][m];
        // 初始条件
        dp[0][0] = grid[0][0];
        // 左边界处理
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        // 上边界处理
        for (int j = 1; j < m; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        printMatrix(dp, n, m);
        return dp[n - 1][m - 1];
    }

    /**
     * 空间复杂度优化后
     */
    public static int leastEnergyCostWithLessSpace(int[][] grid, int n, int m) {
        if (n == 1 && m == 1) {
            return grid[0][0];// 只有一个网格
        }
        int[] dp = new int[m];
        dp[0] = grid[0][0];
        // 处理上边界
        for (int j = 1; j < m; j++) {
            dp[j] = dp[j - 1] + grid[0][j];
        }
        for (int i = 1; i < m; i++) {
            dp[0] = dp[0] + grid[i][0];
            for (int j = 1; j < m; j++) {
                dp[j] = Math.min(dp[j - 1], dp[j]) + grid[i][j];
            }
        }
        return dp[m - 1];
    }

    public static void main(String[] args) {
        int[][] grid = new int[][] {
                {1, 1, 2, 1, 6, 1},
                {1, 2, 1, 6, 5, 1},
                {1, 2, 1, 3, 1, 8},
                {6, 1, 2, 4, 1, 2},
                {2, 3, 2, 3, 4, 1},
                {1, 2, 1, 5, 1, 2},
        };

        printMatrix(grid, grid.length, grid[0].length);
        System.out.println(leastEnergyCostWithLessSpace(grid, grid.length, grid[0].length));

    }

    public static void printMatrix(int[][] mat, int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(mat[i][j] + " ");
                if (j == m - 1) {
                    System.out.println();
                }
            }
        }
        System.out.println();
    }

}
