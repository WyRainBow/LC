package 面经.Tecent.贪吃的小Q;

import java.util.Scanner;

public class Demo0519 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = 3; //出差的天
        int m = 7; //巧克力
        scanner.close();

        System.out.println(maxFirstDayChocolate(n, m)); //4
    }

    public static int maxFirstDayChocolate(int n, int m) {

        int left = 1;
        int right = m;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isFeasibleAmount(mid, n, m)) {
                left = mid + 1;
            } else {

                right = mid - 1;
            }
        }

        // 返回最大可行值
        return right;
    }


    private static boolean isFeasibleAmount(int firstDayAmount, int daysCount, int totalChocolate) {

        long requiredChocolate = 0;
        double dailyAmount = firstDayAmount;

        for (int day = 0; day < daysCount; day++) {
            requiredChocolate += (long) Math.ceil(dailyAmount);
            dailyAmount /= 2.0;
        }
        return requiredChocolate <= totalChocolate;
    }

}
