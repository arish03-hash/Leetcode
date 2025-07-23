class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if(n <= 1)
            return s;

        int max_len = 1;
        String max_str = s.substring(0, 1);

        for(int i = 0; i<n; i++){
            for(int j = i+max_len; j<=n; j++){
                if(j - i > max_len && isPalindrome(s.substring(i, j))){
                    max_len = j - i;
                    max_str = s.substring(i, j);
                }
            }
        }
        return max_str;
    }
    public boolean isPalindrome(String str){
        int l = 0;
        int r = str.length() - 1;

        while(l<r){
            if(str.charAt(l) != str.charAt(r))
                return false;
            
            l++;
            r--;
        }
        return true;
    }
}