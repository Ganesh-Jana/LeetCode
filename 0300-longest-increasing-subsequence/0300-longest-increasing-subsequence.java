class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];

        for(int index = n-1; index>=0; index--){
            for(int prev_index = index-1; prev_index>=-1; prev_index--){
                int notTake = dp[index+1][prev_index+1];

                int Take = 0;
                if(prev_index == -1 || nums[index]>nums[prev_index]){
                    Take = 1 + dp[index+1][index+1];
                }
                dp[index][prev_index+1] = Math.max(notTake, Take);
            }
        }
        return dp[0][0];
        
    }
}