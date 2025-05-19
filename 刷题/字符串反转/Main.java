package 刷题.字符串反转;

public class Main {

    public static void main(String[] args) {
        String s = "abcdefg";
        String result = reverse(s);
        System.out.println(result); // 输出：gfedcba
    }

    public static String reverse(String s) {
        int left = 0;
        int right = s.length() - 1;

        char[] charArray = s.toCharArray();
        while (left <= right) {
            char c = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = c;
            left++;
            right--;
        }

        return new String(charArray);
    }
}