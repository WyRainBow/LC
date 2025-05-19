package LC5;

public class Demo0519 {

    public static void main(String[] args) {
        String s = "babad";
        String result = longestPalindrome(s);
        System.out.println(result);
    }

    public static String longestPalindrome(String s) {
        int n = s.length();

        //问题1
        if (n < 2) {
            return s;
        }

        boolean[][] dp = new boolean[n][n];


        //问题2
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }


        //问题3
        int maxLen = 1;
        int start = 0;

        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    start = i;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }
}

