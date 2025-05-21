package 面经.Tecent.贪吃的小Q;

import java.util.Scanner;

//小Q的父母要出差N天、走之前给小Q留下了M块巧克力。
// 小Q决定每天吃的巧克力数量不少于前一天吃的一半、但是他又不想在父母回来之前的某一天没有巧克力吃
//  请问他第一天最多能吃多少块巧克力
// 输出一个数表示小Q第一天最多能吃多少块巧克力。
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = 3; //出差的天
        int m = 7; //巧克力
        scanner.close();

        System.out.println(maxFirstDayChocolate(n, m)); //4
    }

    /**
     * 计算第一天最多能吃多少块巧克力
     *
     * @param n 天数
     * @param m 巧克力总数
     * @return 第一天最多能吃的巧克力数
     */
    public static int maxFirstDayChocolate(int n, int m) {
        // 二分查找范围：1到m
        int left = 1;
        int right = m;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // 检查以mid为第一天巧克力数量是否可行
            if (isFeasibleAmount(mid, n, m)) {
                // 如果可行，尝试更大的值
                left = mid + 1;
            } else {
                // 如果不可行，尝试更小的值
                right = mid - 1;
            }
        }

        // 返回最大可行值
        return right;
    }



    /**
     * 检查以firstDayAmount为第一天巧克力数量是否可行
     * @param firstDayAmount 第一天吃的巧克力数
     * @param daysCount 父母出差的天数
     * @param totalChocolate 巧克力总数
     * @return 是否可行
     */
    private static boolean isFeasibleAmount(int firstDayAmount, int daysCount, int totalChocolate) {
        // 计算daysCount天内总共需要吃的巧克力数量
        long requiredChocolate = 0;
        double dailyAmount = firstDayAmount;

        for (int day = 0; day < daysCount; day++) {
            requiredChocolate += (long)Math.ceil(dailyAmount);
            dailyAmount /= 2.0; // 下一天至少是前一天的一半
        }

        // 判断是否超过总数量totalChocolate
        return requiredChocolate <= totalChocolate;
    }
}