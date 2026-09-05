class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] minValue = new int[n];
        minValue[n-1] = nums[n-1];

        for(int i = n-2; i>=0; i--){
            minValue[i] = Math.min(nums[i], minValue[i+1]);
        }
        int maxValue = nums[0];
        for(int i = 0; i<n; i++){
            maxValue = Math.max(maxValue, nums[i]);

            int score = maxValue - minValue[i];
            if(score <= k){
                return i;
            }
        }
        return -1;
    }
}