package 面经;

//字符串反转
public class Reverse {

    public static String reverseString(String str) {
        char[] charArray = str.toCharArray();
        int n= charArray.length;
        int left = 0;
        int right =n-1;
        while (left < right) {
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;
            left++;
            right--;
        }
        return new String(charArray);
    }

    public static void main(String[] args) {
        String str = "HelloWorld";
        String reversedStr = reverseString(str);
        System.out.println(str);
        System.out.println(reversedStr);
    }
}
