package 快速.K小元素;

public class KthSmallest {

    public static int findKthSmallest(int[] nums, int k) {
        int index = quickSelect(nums, 0, nums.length - 1, k - 1);
        return nums[index];
    }

    public static int quickSelect(int[] nums, int left, int right, int k) {
        int pivotIndex = partition(nums, left, right);
        if (pivotIndex == k) {
            return pivotIndex;
        } else if (pivotIndex < k) {
            return quickSelect(nums, pivotIndex + 1, right, k);
        } else {
            return quickSelect(nums, left, pivotIndex - 1, k);
        }
    }

    public static int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int i = left + 1, j = right;
        while (i <= j) {
            while (i <= right && nums[i] <= pivot) i++;
            while (j >= left && nums[j] > pivot) j--;
            if (i < j) swap(nums, i, j);
        }
        swap(nums, left, j);
        return j;
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i]; nums[i] = nums[j]; nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {7, 10, 4, 3, 20, 15};
        int k = 3;
        int result = findKthSmallest(nums, k);
        System.out.println("第 " + k + " 小元素是：" + result);
    }
}