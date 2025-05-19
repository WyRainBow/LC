package LC34;

class Solution {


    public  static int[] searchRange(int[] nums, int target) {
        int left = lowerBound(nums, target);
        int right = lowerBound(nums, target + 1) - 1;

        if (left == nums.length || nums[left] != target) {
            return new int[]{-1, -1};
        }

        return new int[]{left, right};
    }

    // 找到第一个大于等于 target 的位置
    public static  int lowerBound(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        Solution solution = new Solution();
        int first = solution.lowerBound(nums, 6);
        int second = solution.lowerBound(nums, 7);
        System.out.println(first);
        System.out.println(second);
    }
}