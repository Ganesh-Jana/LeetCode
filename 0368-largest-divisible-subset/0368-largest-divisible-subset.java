class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();

        Arrays.sort(nums);
        int[] dp = new int[n];
        int[] hash = new int[n];

        Arrays.fill(dp, 1);

        int maxLen = 1;
        int lastIndex = 0;

        for(int i = 0; i<n; i++){
            hash[i] = i;
            for(int j = 0; j<i; j++){

                if(nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1){
                    dp[i] = dp[j] + 1;
                    hash[i] = j;
                }
            }
            if(dp[i] > maxLen){
                maxLen = dp[i];
                lastIndex = i;
            }
        }
        while(hash[lastIndex] != lastIndex){
            list.add(nums[lastIndex]);
            lastIndex = hash[lastIndex];
        }
        list.add(nums[lastIndex]);
        return list;

    }
}