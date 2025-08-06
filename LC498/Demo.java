package LC498;

class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] res = new int[m * n];
        int pos = 0;

        for (int k = 0; k < m + n - 1; k++) {
            if (k % 2 == 1) {
                int i = k < n ? 0 : k - n + 1;
                int j = k < n ? k : n - 1;
                while (i < m && j >= 0) {
                    res[pos] = mat[i][j];
                    pos++;
                    i++;
                    j--;
                }
            } else {
                int i = k < m ? k : m - 1;
                int j = k < m ? 0 : k - m + 1;
                while (i >= 0 && j < n) {
                    res[pos] = mat[i][j];
                    pos++;
                    i--;
                    j++;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[] res = solution.findDiagonalOrder(mat);

        for (int num : res) {
            System.out.print(num + " ");
        }
        System.out.println();
        // 输出: 1 2 4 7 5 3 6 8 9
    }
}