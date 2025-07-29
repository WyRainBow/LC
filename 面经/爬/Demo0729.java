package 面经.爬;

public class Demo0729 {


    public static void main(String[] args) {

        int n = 3;
        int k = 2;
        System.out.println(climbStairs(n, k)); // ✅ 测试用例：n=3、 k=2 应输出 3


    }


    public static int climbStairs(int n, int k) {


        int count = 0;
        if (n == 0) {
            return 1;
        }

        if (n == 1) {
            return 1;
        }


        int[] dp = new int[n + 1];


        dp[0] = 1;

        dp[1] = 1;


        for (int i = 1; i <= n; i++) {
            count = 0;
            for (int j = 1; j <= k; j++) {
                if (i >= j) {
                    count += dp[i - j];
                }
            }
            dp[i] = count;
        }

        return dp[n];

    }

}
