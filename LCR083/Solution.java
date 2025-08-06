package LCR083;

import java.util.*;


class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        List<Integer> path = new ArrayList<>();
        int n = nums.length;

        boolean[] memo = new boolean[n];

        dfs(nums, path, memo, result, 0, n);

        return result;

    }

    public static void dfs(int[] nums, List<Integer> path, boolean[] memo, List<List<Integer>> result, int depth,
                           int n) {

        if (path.size() == n) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (memo[i]) {
                continue;
            }

            memo[i] = true;

            path.add(nums[i]);

            dfs(nums, path, memo, result, depth + 1, n);

            memo[i] = false;

            path.remove(path.size() - 1);

        }

    }

}
