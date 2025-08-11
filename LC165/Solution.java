package LC165;

class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");


        for (String s : v1) {
            System.out.print(s);
            System.out.print(" ");
        }

        System.out.println();

        int n = Math.max(v1.length, v2.length);

        for (int i = 0; i < n; i++) {
            int x = 0, y = 0;
            if (i < v1.length) {
                x = Integer.parseInt(v1[i]);
            }
            if (i < v2.length) {
                y = Integer.parseInt(v2[i]);
            }
            if (x > y) {
                return 1;
            }
            if (x < y) {
                return -1;
            }
        }
        return 0;
    }

    // 测试主函数
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.compareVersion("1.0222221", "1.001")); // 0
    }
}
