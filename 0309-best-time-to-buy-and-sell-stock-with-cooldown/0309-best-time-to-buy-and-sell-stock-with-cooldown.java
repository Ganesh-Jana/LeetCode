class Solution {
    static int f(int index, int buy, int[] prices){

        // int take = Integer.MIN_VALUE, notTake = Integer.MIN_VALUE;
        if(index >= prices.length) return 0;
        int profit = 0;
        if(buy == 1){
            profit =  Math.max(
                (-prices[index] + f(index+1, 0, prices)),
                (0 + f(index+1, 1, prices))
            );
        }else{
            profit =  Math.max(
                (+prices[index] + f(index+2, 1, prices)),
                (0 + f(index+1, 0, prices))
            );
        }
        return profit;
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+2][2];

        for(int i = 0; i<=1; i++){
            dp[n][i] = 0;
        }

        for(int i = n-1; i>=0; i--){
            for(int j = 0; j<=1; j++){
                int profit = 0;
                if(j == 1){
                    profit = Math.max(
                        (-prices[i] + dp[i+1][0]),
                        (0 + dp[i+1][1])
                    );
                }else{
                    profit = Math.max(
                        (prices[i] + dp[i+2][1]),
                        (dp[i+1][0])
                    );
                }
                dp[i][j] = profit;
            }
            
        }
        return dp[0][1];
    }
}