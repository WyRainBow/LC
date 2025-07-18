package LC.快速.快速;

class Solution {

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {3, 2, 1, 5, 4};
        solution.quickSort(nums);

        // 输出排序后的结果
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public void quickSort(int[] nums) {
        quickSortHelper(nums, 0, nums.length - 1);
    }

    // 快速排序的递归方法
    private void quickSortHelper(int[] nums, int left, int right) {
        if (left < right) {
            // 获取分区后的基准元素位置
            int pivotIndex = partition(nums, left, right);

            // 递归排序左半部分
            quickSortHelper(nums, left, pivotIndex - 1);
            // 递归排序右半部分
            quickSortHelper(nums, pivotIndex + 1, right);
        }
    }

    // 快速排序的分区操作
    private int partition(int[] nums, int left, int right) {
        // 选择第一个元素作为基准
        int pivot = nums[left];
        int i = left + 1;  // i 指向左边第一个大于等于基准的元素
        int j = right;     // j 指向右边第一个小于基准的元素

        while (i <= j) {
            // 从左边找到一个大于等于基准的元素
            while (i <= right && nums[i] <= pivot) {
                i++;
            }

            // 从右边找到一个小于等于基准的元素
            while (j >= left && nums[j] > pivot) {
                j--;
            }

            // 如果 i 和 j 没有交叉，交换两个元素
            if (i < j) {
                swap(nums, i, j);
            }
        }

        // 最后将基准元素放到正确的位置
        swap(nums, left, j);
        return j;
    }

    // 交换数组中的两个元素
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}