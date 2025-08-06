package 面经.美团春季笔试0309;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 数组大小
        int q = scanner.nextInt(); // 询问次数
        scanner.nextLine(); // 消耗换行符

        int[] a = new int[n];
        long sum = 0; // 已知部分的总和
        long zeroCount = 0; // 未知元素的数量

        // 读取数组并计算已知部分的总和和未知元素的数量
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            if (a[i] != 0) {
                sum += a[i]; // 累加已知部分
            } else {
                zeroCount++; // 统计未知元素
            }
        }


        for (int i = 0; i < q; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();


            long minSum = sum + zeroCount * l; // 最小和
            long maxSum = sum + zeroCount * r; // 最大和

            // 输出结果
            System.out.println(minSum + " " + maxSum);
        }

        scanner.close();
    }
}