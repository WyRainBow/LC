package LC139;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


public class Main {


    public static boolean isWord(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        System.out.println(set);
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        //	•	dp[i] 表示：前 i 个字符组成的子串 s[0..i-1] 是否可以用字典中的单词拆分
        //	如果前 j 个字符可拆分（dp[j] == true）
        //	•	并且从 j 到 i-1 的子串是字典中的单词
        //	•	那么 dp[i] 就是 true

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] == true) {
                    if (set.contains(s.substring(j, i))) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[n];
    }


    public static void main(String[] args) {
        String s = "leetcode";

        List<String> list = new ArrayList<>();
        list.add("leet");
        list.add("code");
        boolean result = isWord(s, list);
        System.out.println(result);

    }
}
