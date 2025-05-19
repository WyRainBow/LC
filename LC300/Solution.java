package LC300;
import java.util.*;


class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int n = nums.length;

        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1);

        int maxLen = 1;

        //i=2 j=1。//nums[i - 1] > nums[j - 1]
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if (nums[i - 1] > nums[j - 1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }

        return maxLen;
    }


    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] nums=new int[]{10,9,2,5,3,7,101,18};
        int result = solution.lengthOfLIS(nums);
        System.out.println(result);

    }
}