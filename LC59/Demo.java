package LC59;

import java.util.*;


//螺旋矩阵2

public class Demo {

    private static int[][] DIRS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static int[][] generateMatrix(int n) {


        int[][] result = new int[n][n];


        if (n <= 0) {
            return result;
        }

        int i = 0;
        int j = 0;
        int di = 0;

        int num = 1;

        for (int k = 0; k < n * n; k++) {

            result[i][j] = num;
            System.out.print("i=" + i + " j=" + j + " result=" + result[i][j]);
            System.out.print(" ");
            System.out.println();
            num++;

            int x = i + DIRS[di][0];//0
            int y = j + DIRS[di][1]; //1

            // 检查下一步是否越界或已经访问过
            if (x < 0 || x >= n || y < 0 || y >= n || result[x][y] != 0) {
                di = (di + 1) % 4; // 改变方向
            }

            i += DIRS[di][0];
            j += DIRS[di][1];
        }

        return result;
    }


    public static void main(String[] args) {

        int n = 3;
        int[][] result = generateMatrix(n);

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }

    }


}


