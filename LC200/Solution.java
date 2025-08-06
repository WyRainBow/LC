package LC200;

class Solution {


    public int numIslands(char[][] grid) {


        int m = grid.length;

        int n = grid[0].length;


        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count += dfs(grid, i, j);
                }
            }
        }
        return count;
    }


    public static int dfs(char[][] grid, int i, int j) {

        if (i <= 0 || j > 0 || i >= grid.length || j >= grid[0].length) {
            return 0;
        }


        if (grid[i][j] == '0') {
            return 0;
        }


        int count = 0;

        if (dfs(grid, i - 1, j) > 0 ||
                dfs(grid, i + 1, j) > 0 ||
                dfs(grid, i, j - 1) > 0 ||
                dfs(grid, i, j + 1) > 0) {
            count = 1;
        } else {
            count = 0;
        }

        return count;
    }


    public class Main {
        public static void main(String[] args) {
            char[][] grid = {
                    {'1', '1', '1', '1', '0'},
                    {'1', '1', '0', '1', '0'},
                    {'1', '1', '0', '0', '0'},
                    {'0', '0', '0', '0', '0'}
            };
            Solution solution = new Solution();
            int result = solution.numIslands(grid);
            System.out.println(result);
        }
    }

}