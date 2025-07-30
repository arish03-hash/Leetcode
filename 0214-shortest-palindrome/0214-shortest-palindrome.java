class Solution {
    public String shortestPalindrome(String s) {
        int prefix = 0;
        int suffix = 0;
        int base = 29;
        int lastIndex = -1;
        int power = 1;
        int mod = (int)1e9+7;

        for(int i = 0; i<s.length(); i++){
            int ch = s.charAt(i) - 'a' + 1;

            prefix = (prefix * base);
            prefix = (prefix + ch);
            suffix = (suffix + ch*power);
            power = (power * base);
            if(prefix == suffix)
                lastIndex = i;
        }
        StringBuilder str = new StringBuilder(s.substring(lastIndex + 1));
        return str.reverse().toString() + s;
    }
}