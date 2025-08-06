package 中缀表达式系列.Demo1;


//"12+34"：处理这个 没有（号 没有）号  没有 * 号 也没有/号 也没有负数
public class Demo0806 {


    public static void main(String[] args) {

        System.out.println("12+34 = " + calculate("12+34"));     // 46
        System.out.println("5 + 3 - 2 = " + calculate("5 + 3 - 2")); // 6
    }

    public static int calculate(String s) {

        s.replaceAll(" ", "");


        int num = 0;

        int result = 0;

        char op = '+';   // 当前操作符、初始为+（表示第一个数字是正数）


        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);


            //如果是数字
            if (Character.isDigit(c)) {
                num = num * 10 + (int) (c - '0');//转换为整数
            }

            if (c == '+' || c == '-' || i == s.length() - 1) {
                if (op == '+') {
                    result += num;
                } else if (op == '-') {
                    result -= num;
                }

                // 重置数字，更新操作符
                num = 0;
                op = c;  // 当前字符作为下一个数字的操作符
            }

        }

        return result;
    }
}
