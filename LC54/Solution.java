package LC54;

import java.util.*;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        // 检查输入矩阵是否为空
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

        // 定义四个边界
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        // 当矩阵的行和列还有元素时，继续循环
        while (top <= bottom && left <= right) {
            // 从左到右遍历上边界
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++; // 上边界下移

            System.out.println("top: " + top);

            print(result);

            // 从上到下遍历右边界
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--; // 右边界左移

            System.out.println("right: " + right);

            print(result);

            // 如果下边界还有行 遍历从右到左的下边界
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--; // 下边界上移
            }
            System.out.println("bottom: " + bottom);
            print(result);


            // 如果左边界还有列 遍历从下到上的左边界
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++; // 左边界右移
            }
            System.out.println("left: " + left);


            print(result);


            System.out.println();
            System.out.println();
        }

        return result; // 返回结果
    }


    public static void print(List<Integer> list) {
        for (Integer num : list) {
            System.out.print(num);
            System.out.print(" ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner scanner = new Scanner(System.in);
//        int m = scanner.nextInt();
//        int n = scanner.nextInt();
//        int[][] matrix = new int[m][n];
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                matrix[i][j] = scanner.nextInt();
//            }
//        }
//        List<Integer> integers = solution.spiralOrder(matrix);


        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println(solution.spiralOrder(matrix));

    }
}