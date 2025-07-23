class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int max_len = Integer.MIN_VALUE;
        int startInd = 0;
        int[][] dp = new int[1001][1001];
        for(int[] row: dp)
            Arrays.fill(row, -1);

        for(int i = 0; i<n; i++){
            for(int j = i; j<n; j++){
                if(solve(s, i, j, dp)){
                    if(j -i + 1 > max_len){
                        max_len = j - i + 1;
                        startInd = i;
                    }
                }
            }
        }
        return s.substring(startInd, startInd + max_len);
    }
    public boolean solve(String s, int l, int r, int[][] dp) {
        if (l >= r) return true;
        if (dp[l][r] != -1) return dp[l][r] == 1;

        if (s.charAt(l) == s.charAt(r)) {
            boolean result = solve(s, l + 1, r - 1, dp);
            dp[l][r] = result ? 1 : 0;
            return result;
        }

        dp[l][r] = 0;
        return false;
    }

}