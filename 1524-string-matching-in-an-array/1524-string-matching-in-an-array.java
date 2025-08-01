class Solution {
    private int[] kmp(String s){
        int[] lps = new int[s.length()];
        for(int i = 1; i<s.length(); i++){
            int prevInd = lps[i -1];
            while(prevInd > 0 && s.charAt(i) != s.charAt(prevInd))
                prevInd = lps[prevInd - 1];

            lps[i] = prevInd + (s.charAt(i) == s.charAt(prevInd)? 1:0);
        }
        return lps;
    }
    public boolean strStr(String haystack, String needle) {
        String s = needle + "#" + haystack;
        int[] lps = kmp(s);
        int p = needle.length();
        for(int i = 2*p; i<lps.length; i++){
            if(lps[i] == p)
                return true;
        }
        return false;
    }
    public List<String> stringMatching(String[] words) {
        List<String> res = new ArrayList<>();
        int n = words.length;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(i!=j && strStr(words[j], words[i])){
                    res.add(words[i]);
                    break;
                }
            }
        }
        return res;
    }
}