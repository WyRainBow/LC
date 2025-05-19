package LC56;

import java.util.*;


//存在的问题：忘记排序、i忘记++、start 和 end 放错位置
//代码的错误未更改 下次继续看
public class Demo0511 {


    public static void main(String[] args) {

        int[][] nums = new int[][]{
                {1, 3}, {2, 6}, {8, 10}, {15, 18}
        };


        int[][] merged = merge(nums);

        for (int[] interval : merged) {
            System.out.println(Arrays.toString(interval));
        }
    }


    public static int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 0; i < intervals.length; i++) {
            while (i + 1 < intervals.length && end >= intervals[i + 1][0]) {
                end = Math.max(end, intervals[i + 1][1]);
            }

            result.add(new int[]{start, end});
        }


        return result.toArray(new int[result.size()][]);

    }
}
