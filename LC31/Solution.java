package LC31;

class Solution {
    public void nextPermutation(int[] nums) {

        int n = nums.length;

        int i = n - 2;

        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i >= 0) {
            int j = n - 1;

         while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }

         //swap要在里面
            swap(nums, i, j);
        }

        //忘记reverse
        reverse(nums, i + 1, n - 1);
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void reverse(int[] nums, int left, int right) {

        while (left <= right) {
            swap(nums, left++, right--);
        }
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6};

        Solution solution = new Solution();

        solution.reverse(nums, 1, 4);

        for (int num : nums) {
            System.out.print(num);
            System.out.print(" ");
        }


    }
}