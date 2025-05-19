package 刷题.前缀和.LC2602;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
      public List<Long> minOperations(int[] nums, int[] queries) {
        Arrays.sort(nums);

        for(int num : nums){
            System.out.print(num);
            System.out.print(" ");
        }
          System.out.println();
        // 计算前缀和
        int n = nums.length;

          // 构建前缀和数组
          long[] prefixSum = new long[n + 1];  // prefixSum[i] 是 nums[0..i-1] 的和
          prefixSum[0] = 0; // 初始化 prefixSum[0] 为 0

          // 构造前缀和
          for (int i = 1; i <= nums.length; i++) {
              prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
          }
          for (int i = 0; i < prefixSum.length; i++) {
              System.out.print(prefixSum[i]);
              System.out.print(" ");
          }
          System.out.println();

          List<Long> result = new ArrayList<>();

        for (int q : queries) {
            int idx = binarySearchFirstGreaterThanOrEqualToQ(nums, q);
            System.out.println("idx = " + idx);

            // 计算左侧小于q的部分的操作次数
            long leftOperations = (long) q * idx - prefixSum[idx];
            System.out.print("leftOperations = " + leftOperations);
            System.out.print(" ");

            // 计算右侧大于等于q的部分的操作次数
            long rightOperations = (prefixSum[n] - prefixSum[idx]) - (long) q * (n - idx);
            System.out.print("rightOperations = " + rightOperations);


            System.out.println();
            //总操作次数
            result.add(leftOperations + rightOperations);
        }

          System.out.println();

        return result;
    }

    // 二分查找，返回第一个大于等于target的元素索引
    public int binarySearchFirstGreaterThanOrEqualToQ(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{3, 1, 6, 8};
        int[] queries = new int[]{1, 5};
        System.out.println(solution.minOperations(nums, queries));
    }
}