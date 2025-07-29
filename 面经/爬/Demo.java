package 面经.爬;



class Demo {

    public static int climbStairs(int N, int K) {
        int count = 0;

        if (N == 0) {
            return 1; // ✅ 修正：N=0 时应返回 1、表示有一种方式不动
        }

        if (K <= 0) {
            return 0;
        }

        int[] dp = new int[N + 1];

        dp[0] = 1;
        dp[1] = 1; // ⚠️ 这只在 K >= 1 时成立；若 K=0 不应这样写、但前面已处理 K<=0

        for (int i = 1; i <= N; i++) {
            count = 0; // ❌ 错误：count 应该每次循环清零、否则会在外层累加之前的值
            for (int j = 1; j <= K && i - j >= 0; j++) {
                count += dp[i - j];
            }
            dp[i] = count;
        }

        return dp[N];
    }

    public static void main(String[] args) {
        int n = 3;
        int k = 2;
        System.out.println(climbStairs(n, k)); // ✅ 测试用例：n=3、 k=2 应输出 3
    }
}