package 面经.美团春季笔试0309;

import java.util.Scanner;

public class Demo2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 数组大小
        int q = scanner.nextInt(); // 询问次数
        scanner.nextLine(); // 消耗换行符

        int[] nums = new int[n + 1]; // 数组大小 + 1，方便处理前缀和
        long[] prefixSum = new long[n + 1]; // 前缀和数组


        long zeroPrefixCount = 0;
        // 初始化前缀和数组
        prefixSum[0] = 0;


        // 读取数组并计算前缀和
        for (int i = 1; i <= n; i++) {
            nums[i] = scanner.nextInt();
            prefixSum[i] = prefixSum[i - 1] + nums[i]; // 计算前缀和
            if (nums[i] == 0) {
                zeroPrefixCount++;
            }
        }

        // 处理每次询问
        for (int i = 0; i < q; i++) {
            int l = scanner.nextInt(); // 区间左边界
            int r = scanner.nextInt(); // 区间右边界


            long knownSum = prefixSum[n] - prefixSum[0];
            long unknownCount = zeroPrefixCount;


            long minSum = knownSum + unknownCount * l; // 最小和
            long maxSum = knownSum + unknownCount * r; // 最大和

            // 输出结果
            System.out.println(minSum + " " + maxSum);
        }

        scanner.close();
    }
}