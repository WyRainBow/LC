package 快速.快速;

public class Demo0722 {


    public static void main(String[] args) {
        int[] nums = {2, 4, 5, 2, 1};
        quickSort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }


    public static void quickSort(int[] nums) {
        quickSortHelper(nums, 0, nums.length - 1);
    }

    public static void quickSortHelper(int[] nums, int left, int right) {

        if (left <= right) {

            int priotIndex = partition(nums, left, right);

            quickSortHelper(nums, 0, priotIndex - 1);

            quickSortHelper(nums, priotIndex + 1, right);
        }
    }


    public static int partition(int[] nums, int left, int right) {

        int pivot = nums[left];
        int i = left + 1;
        int j = right;


        while (i <= j) {


            while (i <= right && nums[i] <= pivot) {
                i++;
            }


            while (i >= left && nums[j] > pivot) {
                j--;
            }


            if (i < j) {
                swap(nums, i, j);
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
