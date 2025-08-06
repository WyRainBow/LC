package LC165;

class Solution {
    public int compareVersion(String version1, String version2) {

        String[] parts1 = version1.split("\\.");
        String[] parts2 = version2.split("\\.");


        int len1 = parts1.length;
        int len2 = parts2.length;

        int len = Math.max(len1, len2);


        for (int i = 0; i < len; i++) {
            int num1 = 0;
            int num2 = 0;


            if (i < len1) {
                num1 = Integer.parseInt(parts1[i]);
            }


            if (i < len2) {
                num2 = Integer.parseInt(parts2[i]);
            }


            if (num1 != num2) {
                if(num1 > num2){
                    return 1;
                }else{
                    return -1;
                }

            }
        }


        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();


        String version1 = "1.2";
        String version2 = "1.10";
        System.out.println("结果=" + solution.compareVersion(version1, version2)); // 输出: -1


    }
}