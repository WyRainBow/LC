package 刷题.前缀和.Demo;

class Solution {
    // 构造前缀和数组，带头标记
    public int[] constructPrefixSumWithZero(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int[] prefixSum = new int[nums.length + 1];
        prefixSum[0] = 0; // 初始化 prefixSum[0] 为 0

        // 构造前缀和
        for (int i = 1; i <= nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }

        return prefixSum; // 返回前缀和数组
    }

    // 计算区间 [i, j] 的和
    public int rangeSum(int[] prefixSum, int i, int j) {
        return prefixSum[j + 1] - prefixSum[i]; // 利用前缀和数组计算区间和
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 4, 1, 5, 8, 10};

        // 构造前缀和数组，带头标记
        int[] prefixSum = solution.constructPrefixSumWithZero(nums);
        System.out.println("前缀和数组（带头标记）：");
        for (int num : prefixSum) {
            System.out.print(num + " ");
        }
        System.out.println();

        // 计算区间和
        int i = 1, j = 4;
        int sum = solution.rangeSum(prefixSum, i, j);
        System.out.println("区间和 [" + i + ", " + j + "] 的和是: " + sum);
    }
}