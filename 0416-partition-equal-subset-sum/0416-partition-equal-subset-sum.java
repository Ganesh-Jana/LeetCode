class Solution {
    static boolean partition(int index, int target, int[] nums){
        boolean[][] dp = new boolean[index][target + 1];
        for(int i = 0; i<index; i++){
            dp[i][0] = true;
        }
        if(nums[0] <= target){
            dp[0][nums[0]] = true;
        }
        for(int i = 1; i<index; i++){
            for(int j = 1; j<=target; j++){
                boolean notTake = dp[i-1][j];

                boolean take = false;
                if(nums[i] <= j){
                    take = dp[i-1][j - nums[i]];
                }
                dp[i][j] = take || notTake;
            }
        }
        return dp[index-1][target];
    }
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        for(int i = 0; i<n; i++){
            totalSum += nums[i];
        }
        if(totalSum % 2 == 1) return false;
        int target = totalSum /  2;
        
        return partition(n, target, nums);

    }
}