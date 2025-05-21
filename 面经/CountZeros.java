package 面经;


import java.util.Scanner;


//找出字符串中为0的个数
public class CountZeros {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine(); // 输入字符串
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                count++;
            }
        }
        System.out.println(count);
    }
}