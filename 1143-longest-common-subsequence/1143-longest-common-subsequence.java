class Solution {
    static int f(int n, int m, String text1, String text2, int[][] dp){
        if(n<0 || m <0) return 0;

        if(dp[n][m] != -1) return dp[n][m];

        int take = Integer.MIN_VALUE, notTake = Integer.MIN_VALUE;

        if(text1.charAt(n) == text2.charAt(m)){
            take = 1 + f(n-1, m-1, text1, text2, dp);
        }else{
            notTake = Math.max(f(n-1, m, text1, text2, dp), f(n, m-1, text1, text2, dp));
        }
        return dp[n][m] = Math.max(take, notTake);

    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length(), n2 = text2.length();
        int[][] dp = new int[n1][n2];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return f(n1-1, n2-1, text1, text2, dp);
    }
}