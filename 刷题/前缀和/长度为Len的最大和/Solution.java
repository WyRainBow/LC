package 刷题.前缀和.长度为Len的最大和;

class Solution {
    // 计算长度为len的最大子数组和
    public int maxSumOfLength(int[] nums, int len) {
        int n = nums.length;

        // 构造前缀和数组
        int[] prefixSum = new int[n + 1];  // prefixSum[i] 表示 nums[0..i-1] 的和
        prefixSum[0] = 0;
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }

        // 计算长度为len的最大子数组和
        int maxSum = Integer.MIN_VALUE;
        for (int i = len; i <= n; i++) {
            int currentSum = prefixSum[i] - prefixSum[i - len];
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {0, 6, 5, 2, 2, 5, 1, 9, 4};
        int len = 3;

        int result = solution.maxSumOfLength(nums, len);
        System.out.println(result);  // 输出: 15
    }
}