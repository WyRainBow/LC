package LC5;

public class Demo0801 {


    public static void main(String[] args) {
        String s = "babad";
        String result = longestPalindrome(s);
        System.out.println(result);

    }

    public static String longestPalindrome(String s) {


        int n = s.length();
        int start = 0;

        if (n <= 2) {
            return null;
        }


        boolean[][] dp = new boolean[n + 1][n + 1];//


        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        int maxlen = 0;


        for (int i = 1; i < n; i++) {

            for (int j = 0; j < i; j++) {

                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    if (i - j < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                if (dp[i][j] && i - j + 1 > maxlen) {
                    maxlen = Math.max(maxlen, i - j + 1);
                    start = i;
                }
            }

        }


        return s.substring(start, start + maxlen);

    }

}
