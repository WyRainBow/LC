package 刷题.二分;

class Solution {
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

        // 检查 left 是否越界、且是否符合条件
        if (left < nums.length && nums[left] >= target) {
            return left; // 找到了符合条件的位置
        } else {
            return -1; // 没有任何元素满足 >= target
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 3, 4, 4, 4,4,5,5,6};
        int target = 4;

        int result = solution.binarySearchFirstGreaterThanOrEqualToQ(nums, target+1);
        System.out.println(result);
    }
}