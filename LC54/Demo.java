package LC54;

import java.util.ArrayList;
import java.util.List;

public class Demo {

    private static int[][] DIRS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<>();
        }

        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> list = new ArrayList<>(m * n);

        int i = 0;
        int j = 0;
        int di = 0;

        for (int k = 0; k < m * n; k++) {
            list.add(matrix[i][j]);
            matrix[i][j] = Integer.MAX_VALUE; // 标记为已访问
            int x = i + DIRS[di][0];
            int y = j + DIRS[di][1]; // 下一步的位置

            if (x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] == Integer.MAX_VALUE) {
                di = (di + 1) % 4; // 右转 90°
            }
            i += DIRS[di][0];
            j += DIRS[di][1]; // 走一步
        }

        return list;
    }

    public static void main(String[] args) {
        Demo demo = new Demo();


        // 遍历二维数组并按矩阵格式输出
        for (int i = 0; i < DIRS.length; i++) {
            for (int j = 0; j < DIRS[i].length; j++) {
                System.out.print(DIRS[i][j] + " ");
            }
            System.out.println(); // 每一行结束后换行
        }

        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        List<Integer> result = demo.spiralOrder(matrix);
        System.out.println(result); // 输出：[1, 2, 3, 6, 9, 8, 7, 4, 5]
    }
}