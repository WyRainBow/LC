package 练习.去除空格;

public class RemoveSpaces {
    public static void main(String[] args) {
        String str = "  Hello   World  !  ";
        String result = str.replaceAll(" ", "");
        System.out.println(result); // 输出：HelloWorld!
    }
}