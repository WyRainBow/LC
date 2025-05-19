package 刷题.峰谷交;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        //1 2 3 4
        Arrays.sort(nums); // 先排序：升序排列

        int n = nums.length;
        int[] result = new int[n];
        int left = 0, right = n - 1;
        int index = 0;

        while (left <= right) {
            if (left != right) {
                result[index++] = nums[right--]; // 最大值
                result[index++] = nums[left++];  // 最小值
            } else {
                result[index++] = nums[left++];  // 中间值
            }
        }

        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}