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
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return f(0, n-1, s, dp);
    }
}