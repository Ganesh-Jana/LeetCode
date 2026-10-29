class Solution {
    static boolean f(int index, int target, int[] stones, Boolean[][] dp){
        if(target == 0) return true;
        if(index == 0) return stones[0] == target;

        if(dp[index][target] != null) return dp[index][target];

        boolean notTake = f(index-1, target, stones, dp);

        boolean take = false;

        if(stones[index] <= target){
            take = f(index-1, target - stones[index], stones, dp);
        }
        return dp[index][target] = take || notTake;
    }
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;

        if(n == 0) return 0;

        int total = 0;
        for(int stone : stones){
            total += stone;
        }

        int target = total/2;
        Boolean[][] dp = new Boolean[n][target+1];

        for(int s = target; s>=0; s--){
            if(f(n-1, s, stones, dp)){
                return total - 2*s;
            }
        }
        return total;
    }
}