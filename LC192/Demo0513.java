package LC192;

import java.util.*;

public class Demo0513 {

    public static void main(String[] args) {
        String s = "with words +42";
        int result = myAtoi(s);
        System.out.println(result);  // 应输出 0
    }

    public static int myAtoi(String s) {
        if (s == null || s.length() == 0) return 0;

        // 去除前导空格
        s = s.trim();
        if (s.length() == 0) return 0;

        int index = 0;
        int sign = 1;
        long result = 0;

        // 检查第一个字符是否合法
        char firstChar = s.charAt(index);
        if (firstChar != '+' && firstChar != '-' && !Character.isDigit(firstChar)) {
            return 0;
        }

        // 处理符号
        if (firstChar == '+') {
            index++;
        } else if (firstChar == '-') {
            sign = -1;
            index++;
        }

        // 处理数字
        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            int digit = s.charAt(index) - '0';

            // 判断是否溢出
            if (result > Integer.MAX_VALUE / 10 ||
                    (result == Integer.MAX_VALUE / 10 && digit > (sign == 1 ? 7 : 8))) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            index++;
        }

        return (int) (sign * result);
    }
}