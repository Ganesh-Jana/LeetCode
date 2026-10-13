class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long score = 0;

        long[] square = new long[n];
        for(int i = 0; i<n; i++){
            square[i] = (long) nums[i] * nums[i];
        }

        Arrays.sort(square);

        for(int i = 0; i<n; i++){
            if(i< n/2){
                score -= square[i];
            }else{
                score += square[i];
            }
        }
        return score;
    }
}