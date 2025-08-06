package LC463;

class Solution {
    public int islandPerimeter(int[][] grid) {
        int xmax = 1;
        int ymax = 1;

        int m = grid.length;

        int n = grid[0].length;

        int maxPerimeter = 0;

        int flag = 0;//flag=0 是 x flag=1 是y

        int xnumber=0;
        int ynumber=0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                   xnumber+= dfs(grid, i, j, flag);//先算x
                    flag = 1;
                    xmax=Math.max(xmax,xnumber);
                    dfs(grid, i, j, flag);//再算y
                    flag = 0;
                    ymax=Math.max(ymax,ynumber);
                }
            }
        }

        return (xmax)*(ymax);
    }

    public static int dfs(int[][] grid, int i, int j, int flag) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return 0;
        }

        if (grid[i][j] == 0) {
            return 0;
        }

        int length = 1;

        if (flag == 0) {
            length += dfs(grid, i + 1, j,flag);
            length += dfs(grid, i - 1, j,flag);
        } else {
            length += dfs(grid, i, j + 1,flag);
            length += dfs(grid, i, j - 1,flag);
        }

        return length;
    }
}