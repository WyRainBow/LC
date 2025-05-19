package LC300;

import java.util.Arrays;

public class Demo0519 {

    public static void main(String[] args) {

        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        int result = lengthOfLIS(nums);
        System.out.println(result);
    }


    public static int lengthOfLIS(int[] nums) {

        int n = nums.length;

        int[] dp = new int[n + 1];

        Arrays.fill(dp, 1);
        int maxLen = 1;


        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                // 是 nums[i-1]>nums[j-1]
                if (nums[i - 1] > nums[j - 1]) {
                    //这里也要注意
                    dp[i] = Math.max(dp[i], dp[j]     + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }

}
