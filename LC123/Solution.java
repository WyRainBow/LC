package LC123;

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        // 第一次购买后的最大利润
        int firstBuy = -prices[0];
        // 第一次卖出后的最大利润
        int firstSell = 0;
        // 第二次购买后的最大利润
        int secondBuy = -prices[0];
        // 第二次卖出后的最大利润
        int secondSell = 0;

        for (int i = 1; i < n; ++i) {
            int currentNumber = prices[i];

            firstBuy=Math.max(firstBuy,-currentNumber);

            firstSell=Math.max(firstSell,firstBuy+currentNumber);

            secondBuy=Math.max(secondBuy,firstSell-currentNumber);

            secondSell=Math.max(secondSell,secondBuy+currentNumber);
        }

        return secondSell; // 两次交易后的最大利润
    }

    public static void main(String[] args) {

        int[] prices=new int[]{3,3,5,0,0,3,1,4};
        Solution solution=new Solution();
        int result = solution.maxProfit(prices);
        System.out.println(result);
    }
}