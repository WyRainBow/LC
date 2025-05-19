package LC131;

import java.util.Arrays;

class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;

        // 第一步：从后向前找第一个递减的位置
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i >= 0) {
            // 第二步：从后向前找第一个比 nums[i] 大的数
            int j = n - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            // 交换
            swap(nums, i, j);
        }

        // 第三步：反转 i+1 到末尾
        reverse(nums, i + 1, n - 1);
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start++, end--);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        new Solution().nextPermutation(nums);
        System.out.println(Arrays.toString(nums)); // 输出 [1, 3, 2]
    }
}