class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][2][k+1];

        for(int index = n-1; index>= 0; index--){
            for(int buy = 0; buy<=1; buy++){
                for(int trans = 1; trans<=k; trans++){
                    int profit = 0;
                    if(buy == 1){
                            profit = Math.max(-prices[index] + dp[index+1][0][trans], dp[index+1][1][trans]);
                    }else{
                        profit = Math.max(prices[index] + dp[index+1][1][trans-1], dp[index+1][0][trans]);
                    } 
                    dp[index][buy][trans] = profit;
                }
            }
        }
        return dp[0][1][k];

    }
}