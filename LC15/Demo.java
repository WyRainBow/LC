package LC15;

import java.util.*;


/// 三数之和
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        int n = nums.length;
        //忘记了排序

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        if (n <= 2) {
            return result;
        }
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i <= n - 2; i++) {

            //忘记了这个
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = n - 1;

            // 确保左右指针不重合
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }

                    while (right > left && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                }

            }
        }

        return result;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = solution.threeSum(nums);
        for (List<Integer> triplet : result) {
            System.out.println(triplet);
        }
    }
}