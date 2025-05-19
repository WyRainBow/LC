package 刷题.前缀和.LC1031;

class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int n = nums.length;

        // 构造前缀和数组
        int[] prefixSum = new int[n + 1];
        prefixSum[0] = 0;
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }

        // 分别计算两种情况下的最大和，并返回较大值
        // 1. firstLen 在左边，secondLen 在右边
        // 2. secondLen 在左边，firstLen 在右边
        return Math.max(
                calcMaxSum(prefixSum, firstLen, secondLen),
                calcMaxSum(prefixSum, secondLen, firstLen)
        );
    }

    // 计算当 firstLen 长度的子数组在左侧，secondLen 长度的子数组在右侧的最大和
    private int calcMaxSum(int[] prefixSum, int firstLen, int secondLen) {
        int n = prefixSum.length - 1;
        int maxSum = 0;
        int maxFirst = 0;

        // i 代表 secondLen 子数组的结束位置
        for (int i = firstLen + secondLen; i <= n; i++) {
            // 更新 firstLen 子数组的最大和（必须在 secondLen 子数组之前）
            // j 是 firstLen 子数组的结束位置
            int j = i - secondLen;
            maxFirst = Math.max(maxFirst, prefixSum[j] - prefixSum[j - firstLen]);

            // 当前 secondLen 子数组的和
            int secondSum = prefixSum[i] - prefixSum[i - secondLen];

            // 更新最大总和
            maxSum = Math.max(maxSum, maxFirst + secondSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {0, 6, 5, 2, 2, 5, 1, 9, 4};
        int firstLen = 1;
        int secondLen = 2;

        int result = solution.maxSumTwoNoOverlap(nums, firstLen, secondLen);
        System.out.println(result);  // Expected output: 20
    }
}