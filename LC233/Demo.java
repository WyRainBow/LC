package LC233;

import java.util.*;

class Demo233 {

    public static int digitOneInNumber(int num) {
        int totalCount = 0;
        List<Integer> numbersWithOne = new ArrayList<>();
        List<String> detailInfo = new ArrayList<>();

        // 遍历所有小于等于 num 的非负整数
        for (int i = 0; i <= num; i++) {
            int countInCurrent = countOnesInNumber(i);
            if (countInCurrent > 0) {
                numbersWithOne.add(i);
                detailInfo.add("数字 " + i + " 包含 " + countInCurrent + " 个数字1");
                totalCount += countInCurrent;
            }
        }

        // 输出结果

        System.out.println("包含数字1的所有数字:");
        for (String info : detailInfo) {
            System.out.println(info);
        }
        System.out.println();

        System.out.println("包含数字1的数字列表: " + numbersWithOne);
        System.out.println("数字1出现的总次数: " + totalCount);

        return totalCount;
    }

    // 计算单个数字中包含多少个数字1
    private static int countOnesInNumber(int number) {
        int count = 0;
        String numStr = String.valueOf(number);
        for (char c : numStr.toCharArray()) {
            if (c == '1') {
                count++;
            }
        }
        return count;
    }

    // 测试方法
    public static void main(String[] args) {


        // 测试不同的数值
        int[] testCases = {13, 0};

        for (int testNum : testCases) {

            int result = digitOneInNumber(testNum);
            System.out.println("最终结果: " + result);

        }
    }
}