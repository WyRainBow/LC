package 练习.小浪;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取输入
        int n = scanner.nextInt(); // 城市数量
        int k = scanner.nextInt(); // 花费差值的最大绝对值限制

        // 边界条件：如果没有城市，直接返回0
        if (n == 0) {
            System.out.println(0);
            scanner.close();
            return;
        }

        // 存储城市信息(花费 开心值)
        int[][] cities = new int[n][2];
        for (int i = 0; i < n; i++) {
            cities[i][0] = scanner.nextInt(); // 花费 x
            cities[i][1] = scanner.nextInt(); // 开心值 y
        }

        // 按花费排序，启用滑动窗口算法
        Arrays.sort(cities, Comparator.comparingInt(a -> a[0]));

        /*
         * 滑动窗口解法思路：
         * 1. 当城市按花费排序后，窗口内最大花费和最小花费的差值就是cities[right][0] - cities[left][0]
         * 2. 通过调整left和right，确保窗口中所有城市的花费差值小于k
         * 3. 任意两个城市之间的花费差值都不会超过最大值与最小值的差
         * 4. 因此，滑动窗口可以确保窗口内任意两个城市的花费差值都小于k
         */
        int left = 0;
        int maxHappiness = 0;
        int currentHappiness = 0;

        for (int right = 0; right < n; right++) {
            // 加入右端点城市的开心值
            currentHappiness += cities[right][1];

            // 保持窗口内所有城市的花费差值严格小于k
            while (left < right && cities[right][0] - cities[left][0] >= k) {
                currentHappiness -= cities[left][1];
                left++;
            }

            // 更新最大开心值
            maxHappiness = Math.max(maxHappiness, currentHappiness);
        }

        System.out.println(maxHappiness);
        scanner.close();
    }
}


