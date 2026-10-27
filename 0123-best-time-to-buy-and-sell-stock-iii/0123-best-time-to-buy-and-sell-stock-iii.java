class Solution {
    static int f(int index, int buy, int trans, int[] prices, int n, int[][][] dp){

        if(index == n) return 0;
        if(trans == 0) return 0;

        if(dp[index][buy][trans] != -1) return dp[index][buy][trans];
        int profit = 0;
        if(buy == 1){
            profit = Math.max(-prices[index] + f(index+1, 0, trans, prices, n, dp),
                                0 + f(index+1, 1, trans, prices, n, dp));
        }else{
            profit = Math.max(prices[index] + f(index+1, 1, trans-1, prices, n, dp),
                                0 + f(index+1, 0, trans, prices, n, dp));
        }
        return dp[index][buy][trans] = profit;

    }
    public int maxProfit(int[] prices) {
       int n = prices.length;
       int[][][] dp = new int[n][2][3];
       for(int[][] rows : dp){
        for(int[] row : rows){
       
        Arrays.fill(row, -1);
       }
       }
       return f(0, 1, 2, prices, n, dp);

    }
}