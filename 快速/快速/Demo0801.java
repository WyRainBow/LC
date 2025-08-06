package 快速.快速;


public class Demo0801 {


    public static void main(String[] args) {
        int[] nums = {1, 4, 4, 3, 5, 2, 1};

        quickSort(nums, 0, nums.length - 1);

        for (int num : nums) {
            System.out.println(num);
        }
    }


    public static void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int index = partiton(nums, left, right);

            quickSort(nums, left, index - 1);

            quickSort(nums, index + 1, right);
        }
    }


    public static int partiton(int[] nums, int left, int right) {

        int pivot = nums[left];
        int i = left + 1;

        int j = right;

        while (i <= j) {

            while (i <= right && nums[i] <= pivot) {
                i++;
            }

            while (j >= left && nums[j] > pivot) {
                j--;
            }


            if (i < j) {
                swap(nums, i, j);
            }
        }


        //这里写错了
        //swap(nums, i, left);

        swap(nums, left, j);
        return j;
    }


    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
