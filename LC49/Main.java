package LC49;

import java.util.*;
import java.util.Scanner;

public class Main {
    // 处理异位词分组的方法
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] strs = input.split(" ");

        Main solution = new Main();
        List<List<String>> result = solution.groupAnagrams(strs);

        for (List<String> group : result) {
            System.out.println(group);
        }

        // 关闭 Scanner
        scanner.close();
    }
}