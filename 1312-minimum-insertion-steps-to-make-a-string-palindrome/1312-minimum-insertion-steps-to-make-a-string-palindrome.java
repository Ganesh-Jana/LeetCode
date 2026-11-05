class Solution {
    static int f(int first, int last, String s, int[][] dp){
        if(first == last) return 0;
        if(first>last) return 0;

        if(dp[first][last] != -1) return dp[first][last];

        if(s.charAt(first) == s.charAt(last)){
            return dp[first][last]  = 0 + f(first+1, last-1, s, dp);
        }else{
            return dp[first][last] =  Math.min(1 + f(first+1, last, s, dp), (1 + f(first, last-1, s, dp)));
        }
    }
    public int minInsertions(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(i == j) dp[i][j] = 0;
                else if(i>j) dp[i][j] = 0;
            }
        }

        for(int i = n-1; i>=0; i--){
            for(int j = i+1; j<n; j++){
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1];
                }else{
                    dp[i][j] = Math.min((1 + dp[i+1][j]), (1+ dp[i][j-1]));
                }
            }
        }
        return dp[0][n-1];
        
    }
}