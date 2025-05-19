package 快速.LC215K大元素;

public class Demo0515 {
    public static int findKthLargest(int[] nums, int k) {

        //找出第K大元素
        int index = quickSelect(nums, 0, nums.length - 1, nums.length - k);
        return index;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1, 5, 6, 4};
        int k = 2;
        //忘记改了
        int index = findKthLargest(nums, k);
        System.out.println(nums[index]);
    }


    public static int quickSelect(int[] nums, int left, int right, int k) {

        //
        int index = partition(nums, left, right);

        if (index == k) {
            return index;
        } else if (index < k) {
            return quickSelect(nums, index + 1, right, k);
        } else {
            return quickSelect(nums, left, index - 1, k);
        }

    }

    public static int partition(int[] nums, int left, int right) {

        int i = left + 1;
        int j = right;
        int priot = nums[left];

        while (i <= j) {


            //
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
