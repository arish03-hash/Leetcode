class Solution {
    public int maxDepth(String s) {
        int ans = 0;
        int cur = 0;
        for(char ch: s.toCharArray()){
            if(ch == '(')
                ans = Math.max(ans, ++cur);
            else if(ch == ')')
                cur--;
        }
        return ans;
    }
}