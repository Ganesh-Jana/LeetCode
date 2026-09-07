class Solution {
    public static int solve(int[]coins, int index, int amount, int[][] dp){
        if(amount == 0) return 0;
        if(index == 0){
            if(amount % coins[index] == 0) return amount/coins[index];
            else return 1000000000;
        }
        if(dp[index][amount] != -1) return dp[index][amount];
        int notTake = 0 + solve(coins, index-1, amount, dp);
        int take = 1000000000;
        if(coins[index] <= amount){
            take = 1 + solve(coins, index, amount - coins[index], dp);
        }
       return dp[index][amount] = Math.min(take, notTake);
    }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        
        int ans =  solve(coins, n-1, amount, dp); 
        if(ans >= 1000000000){
            return -1;
        }     
        return ans;
    }
}