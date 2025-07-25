class Solution {
    public int countHomogenous(String s) {
        int ans = 0;
        int cur = 0;
        int cnt = 0;
        int mod = (int)1e9 + 7;
        for(char ch: s.toCharArray()){
            if(ch == cur)
                cnt++;
            else
                cnt = 1;
            cur = ch;
            ans = (ans + cnt) % mod;
        }
        return ans;
    }
}