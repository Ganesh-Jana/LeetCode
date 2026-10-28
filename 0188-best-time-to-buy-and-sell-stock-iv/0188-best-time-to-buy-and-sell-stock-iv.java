class Solution {
    static int f(int index, int buy, int trans, int n, int[] prices, int[][][] dp){
        if(index == n || trans == 0) return 0;

        if(dp[index][buy][trans] != -1) return dp[index][buy][trans];

        int profit = 0;
        if(buy == 1){
                profit = Math.max(-prices[index] + f(index+1, 0, trans, n, prices, dp), f(index+1, 1, trans, n, prices, dp));
        }else{
            profit = Math.max(prices[index] + f(index+1, 1, trans-1, n, prices, dp), 
                                f(index+1, 0, trans, n, prices, dp));
        }
        return dp[index][buy][trans] = profit;
    }
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][k+1];

        for(int[][] row : dp){
            for(int[] rows : row){
                Arrays.fill(rows, -1);
            }
        }
        return f(0, 1, k, n, prices, dp);
    }
}