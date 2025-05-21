package 面经.小浪;

import java.util.*;

public class Demo {
    public static void main(String[] args) {
        // 输入数据写死
        int n = 5;  // 城市数量
        int k = 3;  // 花费差值的最大绝对值限制
        
        // 城市信息(花费x, 开心值y)
        int[][] cities = {
                {1, 3},
                {2, 1},
                {5, 2},
                {3, 1},
                {4, 3}
        };

        // 按花费排序
        Arrays.sort(cities, (a, b) -> a[0] - b[0]);

        // 滑动窗口算法
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
    }
}



