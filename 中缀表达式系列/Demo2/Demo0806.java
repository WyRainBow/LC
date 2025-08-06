package 中缀表达式系列.Demo2;

import java.util.ArrayDeque;
import java.util.Deque;


//"3+2*2"：处理这个 没有（号 没有）号
//没有负数    只处理加减乘除法、没有括号、没有负数：

public class Demo0806 {

    public static int calculate(String s) {

        Deque<Integer> stack = new ArrayDeque<Integer>();
        char preSign = '+';
        int num = 0;
        int n = s.length();


        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                num = num * 10 + s.charAt(i) - '0';
            }


            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == n - 1) {

                switch (preSign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    default:
                        stack.push(stack.pop() / num);
                }
                preSign = c;
                num = 0;
            }
        }

        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println("1+2+3*4 = " + calculate("1+2+3*4")); // 15
        System.out.println("100-25 = " + calculate("100-25"));   // 75
        System.out.println("10-3*5 = " + calculate("10-3*5"));   // -5
        System.out.println("14/2-3 = " + calculate("14/2-3"));   // 4
        System.out.println("3+2*2 = " + calculate("3+2*2"));     // 7
    }
}
