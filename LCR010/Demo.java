package LCR010;

import java.util.*;

class Solution {
    public int subarraySum(int[] nums, int k) {




        // key: 前缀和、value: 该前缀和出现的所有下标列表
        Map<Integer, List<Integer>> map = new HashMap<>();
        int count = 0;
        int prefixSum = 0;

        // 初始化前缀和为0时的下标为-1（方便处理从头开始的子数组）
        map.put(0, new ArrayList<>());
        map.get(0).add(-1);

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];

            // 如果存在前缀和 prefixSum - k\说明中间的子数组和为k
            if (map.containsKey(prefixSum - k)) {
                List<Integer> indices = map.get(prefixSum - k);
                for (int startIdx : indices) {
                    // 输出具体子数组内容
                    System.out.print("一个和为" + k + "的组: [");
                    for (int j = startIdx + 1; j <= i; j++) {
                        System.out.print(nums[j]);
                        if (j < i) {
                            System.out.print(" ");
                        }
                    }
                    System.out.println("]");
                    count++;
                }
            }

            // 记录当前前缀和出现的位置
            if (!map.containsKey(prefixSum)) {
                map.put(prefixSum, new ArrayList<>());
            }
            map.get(prefixSum).add(i);
        }

        System.out.println(count);
        return count;
    }

    // 测试
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 2, 3};
        int k = 3;
        sol.subarraySum(nums, k);
    }
}