package LC.快速.快速;

public class Demo0513 {

    public static void main(String[] args) {

        int[] nums = new int[]{5, 8, 1, 3, 2};

        quickSort(nums, 0, nums.length - 1);

        for (int num : nums) {
            System.out.println(num);
        }
    }


    public static void quickSort(int[] nums, int left, int right) {

        if (left < right) {
            int priotIndex = partition(nums, left, right);

            quickSort(nums, 0, priotIndex - 1);
            quickSort(nums, priotIndex + 1, right);
        }
    }


    public static int partition(int[] nums, int left, int right) {
        int priot = nums[left];
        int i = left + 1;

        int j = right;

        //经典犯错
        while (i <= j) {

            while (i <= right && nums[i] <= priot) {
                i++;
            }

            while (j >= left && nums[j] > priot) {
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
