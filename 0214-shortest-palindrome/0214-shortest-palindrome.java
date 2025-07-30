#################################################################################
#Rabin Karp
#################################################################################
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

#######################################################################################

class Solution {
    public Boolean isPalindrome(String s, int l, int r){
        while(l<=r){
            if(s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }

    public String shortestPalindrome(String s) {
        for(int i=s.length() - 1; i>=0; i--){
            if(isPalindrome(s, 0, i)){
                String suffix = s.substring(i+1);
                StringBuilder sb = new StringBuilder(suffix);
                return sb.reverse().toString() + s;
            }
        }
        return "";
    }
}

############################################################################################
