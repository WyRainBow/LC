package LC192;

import java.util.Scanner;

class Solution {
    public static int myAtoi(String str) {

        if (str.length() == 0) {
            return 0;
        }

        // 先处理前导空格，只保留数字和符号
        String newstr = str.trim().replaceAll("[a-zA-Z]", "");
        if (newstr.length() == 0) {
            return 0;
        }

        String[] s = newstr.split("");
        int sign = 1;
        int result = 0;
        int j = 0;

        // 处理符号
        String flag = s[0];
        if (flag.equals("-")) {
            sign = -1;
            j++;
        } else if (flag.equals("+")) {
            j++;
        }

        for (int i = j; i < s.length; i++) {
            // 只处理数字字符
            if (s[i].matches("\\d")) {
                int temp = Integer.parseInt(s[i]);
                if (i >= j) {
                    result = result * 10 + temp;
                } else {
                    result = temp;
                }

                // 检查是否溢出
                if (result < 0) { // 如果发生溢出
                    return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
            } else {
                // 遇到非数字字符就停止
                break;
            }
        }

        return sign * result;
    }

    public static void main(String[] args) {
        String s = "4193 with words";
        int result = myAtoi(s);
        System.out.println(result);
        System.out.println(myAtoi("   -42"));
        System.out.println(myAtoi("words and 987"));
    }
}