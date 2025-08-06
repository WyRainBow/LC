package 中缀表达式系列.Demo1;

import java.util.ArrayDeque;
import java.util.Deque;

public class DemoStack0805 {


    public static void main(String[] args) {

        System.out.println("12+34 = " + calculate("12+34"));     // 46


    }

    public static int calculate(String s) {
        s = s.replaceAll(" ", "") + "+";

        Deque<Integer> stack = new ArrayDeque<>();
        int num = 0;
        char sign = '+'; // 数字前面的符号


        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }

            if (c == '+' || c == '-' || i == s.length() - 1) {

                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                }

                // 在 if 里面
                sign = c;
                num = 0;
            }

        }

        // 将栈中所有数字相加
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;

    }
}
