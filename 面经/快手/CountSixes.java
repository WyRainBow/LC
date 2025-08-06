package 面经.快手;

public class CountSixes {

    public static int countSixesWithMath(int limit) {
        int count = 0;
        // 遍历从1到limit的每一个数字
        for (int i = 1; i <= limit; i++) {
            int currentNumber = i;

            // 当数字大于0时、循环检查它的每一位
            while (currentNumber > 0) {
                // 取出个位数 (例如 66 % 10 -> 6)
                if (currentNumber % 10 == 6) {
                    count++;
                }
                // 去掉个位数 (例如 66 / 10 -> 6)
                currentNumber /= 10;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int limit = 100;


        int occurrencesByString = countSixesWithMath(limit);


        System.out.println(occurrencesByString);


    }


}