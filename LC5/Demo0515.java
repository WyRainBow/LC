package LC5;

public class Demo0515 {

    public static void main(String[] args) {
        String s = "babad";
        String result = longestPalindrome(s);
        System.out.println(result);
    }

    public static String longestPalindrome(String s) {

        int n = s.length();

        if (n < 2) {
            return s;
        }


        boolean[][] dp = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = false;
        }

        int maxLen = 0;
        int start = 0;


        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    // 情况一：子串长度小于等于3（即 j - i < 3）
                    // 比如 "aa"、"aba"，只要首尾相等、肯定是回文
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        // 情况二：子串长度大于3
                        // 则需要看中间的子串 s[i+1..j-1] 是否是回文（即 dp[i+1][j-1]）
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                if (dp[i][j] == true && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    start = i;
                }
            }
        }

        return s.substring(start, start + maxLen);


    }
}
