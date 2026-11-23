class Solution {
    private boolean solve(int i, int j, String s, String p, Boolean[][] dp){
        if(i == s.length() && j == p.length()){
            return true;
        }
        if(j == p.length()){
            return false;
        }

        if(i == s.length()){
            for(int k = j; k<p.length(); k++){
                if(p.charAt(k) != '*') return false;
            }
            return true;
        }
        if(dp[i][j] != null) return dp[i][j];

        if(p.charAt(j) == '?' || s.charAt(i) == p.charAt(j)){
            dp[i][j] = solve(i+1, j+1, s, p, dp);
        }
        else if(p.charAt(j) == '*'){
            boolean notTake = solve(i, j+1, s, p, dp);

            boolean take = solve(i+1, j, s, p, dp);

            dp[i][j] = notTake || take;
        }else{
            dp[i][j] = false;
        }
        return dp[i][j];

    }
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();

        Boolean[][] dp = new Boolean[n][m];
        return solve(0, 0, s, p, dp);
    }
}