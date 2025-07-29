package 面经.爬;




// N层台阶 每次可以走K步
// 小红书一面


class Main {

    public static int climbStairs(int N, int K) {


        //
        int count = 0;

        if (N == 0) {
            return 0;
        }

        if (K <= 0) {
            return 0;
        }

        int[] dp = new int[N + 1];

        dp[0] = 1;
        dp[1] = 1;


        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K && i - j >= 0; j++) {
                count += dp[i - j];
            }
            dp[i] = count;
        }

        return dp[N];

    }


    public static void main(String[] args) {
        int n = 3;
        int k = 1;
        System.out.println(climbStairs(n, k));
    }


}
   