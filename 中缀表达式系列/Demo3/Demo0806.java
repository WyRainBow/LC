package 中缀表达式系列.Demo3;

import java.util.ArrayDeque;
import java.util.Deque;


//加减有负号

class CalculatorWithNegatives {
    public int calculate(String s) {
        // 存放所有的数字
        Deque<Integer> nums = new ArrayDeque<>();
        // 为了防止第一个数为负数、或出现 (+-...) 的情况、先往 nums 加个 0
        nums.addLast(0);
        // 将所有的空格去掉
        s = s.replaceAll(" ", "");
        // 存放所有的操作
        Deque<Character> ops = new ArrayDeque<>();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                // 解析完整数字
                int num = 0;
                int j = i;
                while (j < n && Character.isDigit(s.charAt(j))) {
                    num = num * 10 + (s.charAt(j) - '0');
                    j++;
                }
                nums.addLast(num);
                i = j - 1; // 更新外层循环的 i
            } else {

                // 只要操作符栈有东西、就计算。因为加减平级
                if (!ops.isEmpty()) {
                    calc(nums, ops);
                }
                ops.addLast(c);
            }
        }
        // 计算最后剩余的操作
        if (!ops.isEmpty()) {
            calc(nums, ops);
        }
        return nums.peekLast();
    }

    void calc(Deque<Integer> nums, Deque<Character> ops) {
        // 保证有两个数可以计算
        if (nums.isEmpty() || nums.size() < 2 || ops.isEmpty()) {
            return;
        }
        int b = nums.pollLast();
        int a = nums.pollLast();
        char op = ops.pollLast();
        nums.addLast(op == '+' ? a + b : a - b);
    }

    // 测试方法
    public static void main(String[] args) {
        CalculatorWithNegatives calc = new CalculatorWithNegatives();
        System.out.println("10-3+5 = " + calc.calculate("10-3+5"));   // 12
        System.out.println("-5+10-8 = " + calc.calculate("-5+10-8"));     // -3
        System.out.println("10 + -5 = " + calc.calculate("10 + -5")); // 5
        System.out.println("-2 + -3 = " + calc.calculate("-2 + -3")); // -5
    }
}