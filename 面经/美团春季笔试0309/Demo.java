package 面经.美团春季笔试0309;

import java.util.*;

public class Demo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 输入字符串长度
        int k = scanner.nextInt(); // 输入操作次数
        scanner.nextLine(); // 消耗掉换行符


        String s = scanner.nextLine(); // 输入字符串
        scanner.close();

        System.out.println(cc(s, k)); // 输出结果
    }

    public static int cc(String s, int k) {
        int number = 0;
        int count = 0;


        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == 'M' || c == 'T') {
                number++;
            } else {
                count++;
            }
        }


        count = Math.min(count, k);


        int result = number + count;

        return result;
    }
}