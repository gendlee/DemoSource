package chap7;

public class JumpStairs {

    // 爬楼梯
    public static int jumpStairs(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        int[] dp = new int[n + 1];  // 要获取dp[n]，需要定义n+1长度的数组
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        String printForm = "n=%d，共有 %d 中方法";
        int n = 5;

        System.out.println(String.format(printForm, n, jumpStairs(n)));
    }

}
