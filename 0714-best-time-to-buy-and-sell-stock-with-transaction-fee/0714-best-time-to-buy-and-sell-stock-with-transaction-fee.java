class Solution {
    static int f(int index, int buy, int fee, int[] prices, int[][] dp){
        int n = prices.length;
        if(index == n) return 0;
        if(dp[index][buy] != -1) return dp[index][buy];

        int profit = 0;
        if(buy == 1){
            profit = Math.max(-prices[index] + f(index +1, 0, fee, prices, dp), 
                                f(index+1, 1, fee, prices, dp));
        } else{
            profit = Math.max(prices[index] - fee + f(index+1, 1, fee, prices, dp),
                                f(index+1, 0, fee, prices, dp));
        }
        return dp[index][buy] = profit;
    }
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;

        int[][] dp = new int[n][2];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return f(0, 1, fee,  prices, dp);
    }
}