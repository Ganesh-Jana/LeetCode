class Solution {
    static boolean compare(String string1, String string2){
        if(string1.length() != string2.length()+1) return false;

        int first = 0;
        int second = 0;
        while(first < string1.length()){
            if(second < string2.length() && string1.charAt(first) == string2.charAt(second)){
                first++;
                second++;
            }else{
                first++;
            }
        }
        if(first == string1.length() && second == string2.length()) return true;
        return false;
    }
    public int longestStrChain(String[] words) {
        int n = words.length;

        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int maxi = 1;
        for(int i = 0; i<n; i++){
            for(int prev_index = 0; prev_index<i; prev_index++){
                if(compare(words[i] , words[prev_index])){
                    dp[i] = Math.max(dp[i], 1 + dp[prev_index]);
                }
            }
            maxi = Math.max(maxi, dp[i]);
        }
        return maxi;
    }
}