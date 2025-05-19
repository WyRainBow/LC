package LC3432;

class Solution {
    public static int countPartitions(int[] nums) {
        int count = 0;
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] prefixSum = new int[nums.length + 1];
        prefixSum[0] = 0; // 初始化 prefixSum[0] 为 0

        // 构造前缀和
        for (int i = 1; i <= nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }


        for (int i = 0; i < prefixSum.length; i++) {
            System.out.print(prefixSum[i]);
            System.out.print(" ");
        }

        int n=nums.length;
        System.out.println();


        for(int i=1;i<n;i++){
            int currentnum=prefixSum[i];
            System.out.print(currentnum);
            System.out.print("----");

            int sum=rangeSum(prefixSum,i,n-1);
            System.out.print(sum);
            System.out.print(" ");

            if((currentnum-sum)%2==0){
                count++;
            }
            System.out.println();
        }


        return count;
    }

    // 计算区间 [i, j] 的和
    public static int rangeSum(int[] prefixSum, int i, int j) {
        return prefixSum[j + 1] - prefixSum[i];

    }


    public static void main(String[] args) {
        int[] nums = new int[]{10,10,3,7,6};
        int count = countPartitions(nums);
        System.out.println(count);

    }

}