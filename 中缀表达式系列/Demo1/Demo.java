package 中缀表达式系列.Demo1;

public class Demo {

    public static void main(String[] args) {
        System.out.println("12+34 = " + calculate("12+34"));     // 46

        System.out.println("5 + 3 - 2 = " + calculate("5 + 3 - 2")); // 6
    }

    public static int calculate(String s) {

        s.replaceAll(" ", "");

        int result = 0;

        int num = 0;

        char op = '+';


        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                num = num * 10 + (int) (c - '0');
            }

            if (c == '+' || c == '-' || i == s.length() - 1) {
                if (op == '+') {
                    result += num;
                } else if (op == '-') {
                    result -= num;
                }

                //在 if 里面
                num = 0;
                op = c;
            }


        }

        return result;

    }
}
