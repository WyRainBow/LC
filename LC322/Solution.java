package LC322;

import java.util.*;

class Solution {
    public int coinChange(int[] coins, int amount) {

        int n = coins.length;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < n; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i - coins[j]], dp[i]) + 1;
                    System.out.print(dp[i]);
                    System.out.print(" ");
                }
            }
            System.out.println("i:" + i);
        }
        if (dp[amount] != Integer.MAX_VALUE) {
            return dp[amount];
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] conis = new int[]{2};
        int amount = 3;
        Solution solution = new Solution();
        int result = solution.coinChange(conis, amount);
        System.out.println(result);

    }
}