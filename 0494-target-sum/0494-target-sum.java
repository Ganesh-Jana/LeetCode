class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int totalSum = 0;
        for(int i = 0; i<n; i++){
            totalSum += nums[i];
        }
        if(totalSum + target < 0) return 0;
        if((totalSum + target) % 2 != 0) return 0;
        int sum = (totalSum + target)/2;
        int[][] dp = new int[n][sum+1];

        for(int i = 0; i<n; i++){
            dp[i][0] = 1;
        }
        if(nums[0] == 0){
            dp[0][0] = 2;
        }else{

            dp[0][0] = 1;
        if(nums[0] <= sum){
            dp[0][nums[0]] = 1;
        }
        }
        for(int i = 1; i<n; i++){
            for(int j = 0; j<=sum; j++){
                int notTake = dp[i-1][j];

                int take = 0;
                if(nums[i] <= j){
                    take = dp[i-1][j - nums[i]];
                }
                dp[i][j] = take + notTake;
            }
        }
        return dp[n-1][sum];
    }
}