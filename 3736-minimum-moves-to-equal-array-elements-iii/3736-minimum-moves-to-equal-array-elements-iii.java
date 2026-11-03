class Solution {
    public int minMoves(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<n; i++){
            max = Math.max(max, nums[i]);
        }
        int cnt = 0;
        
        int sum = 0;
        for(int i = 0; i<n; i++){
            if(nums[i] == max) cnt++;
           else if(nums[i] == max) continue;
            else sum += nums[i];
        }
        return max*(n-cnt) - sum;
        
    }
}