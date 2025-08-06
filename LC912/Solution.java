package LC912;

class Solution {
    public int[] sortArray(int[] nums) {

        quickSort(nums, 0, nums.length - 1);

        return nums;
    }

    public static void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int priotIndex = partition(nums,left, right);

            quickSort(nums, left, priotIndex - 1);

            quickSort(nums, priotIndex + 1, right);
        }
    }

    public static int partition(int[] nums, int left, int right) {

        int i = left + 1;
        int j = right;
        int pivot = nums[left];

        while (i <= j) {
            while (i <= right && nums[i] <= pivot) {
                i++;
            }

            while (j >= left && nums[j] > pivot) {
                j--;
            }

            if (i < j) {
                swap(nums,i, j);
            }
        }

        swap(nums, left, j);
        return j;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}