class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for(int i = 0; i<n; i++){
            dp[i] = 1;
        }

       int maxi = 1;
       for(int i = 0; i<n; i++){
        for(int prev_index = 0; prev_index<i; prev_index++){

            if(nums[prev_index] < nums[i]){
                dp[i] = Math.max(dp[i], 1 + dp[prev_index]);
            }
        }
        maxi = Math.max(maxi, dp[i]);
       }
       return maxi;

        
    }
}