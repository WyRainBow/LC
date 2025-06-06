package LC62;

class Solution {
    public int uniquePaths(int m, int n) {

        int count = 0;

        //1 1
        //1
        //1

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                System.out.print(dp[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }

        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int m = 3;
        int n = 7;

        int count = solution.uniquePaths(m, n);
        System.out.println(count);
    }
}