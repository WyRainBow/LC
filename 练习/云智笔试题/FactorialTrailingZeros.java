package 练习.云智笔试题;

/**
 * 阶乘中0的个数
 * 给定一个整数 n，求 n!（即 n 的阶乘）中末尾有多少个零
 */
public class FactorialTrailingZeros {

    public static void main(String[] args) {
        int n = 10;
        System.out.println(factorialTrailingZeros(n));
    }

    public static int factorialTrailingZeros(int n) {
        //计算阶乘
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }

        String s = Long.toString(result);

        int count = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}