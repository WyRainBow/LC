package LC56;

import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int n = intervals.length;

        List<int[]> result = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            while (i + 1 < n && end >= intervals[i + 1][0]) {
                end = Math.max(end, intervals[i + 1][1]);
                i++;
            }

            result.add(new int[]{start, end});
        }

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {1, 3}, {2, 6}, {8, 10}, {15, 18}
        };

        Solution s = new Solution();
        int[][] merged = s.merge(nums);

        for (int[] interval : merged) {
            System.out.println(Arrays.toString(interval));
        }
    }
}