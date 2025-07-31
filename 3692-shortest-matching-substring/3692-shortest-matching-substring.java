class Solution {
    private int[] kmp(String s){
        int[] lps = new int[s.length()];
        for(int i = 1; i<s.length(); i++){
            int prevIdx = lps[i-1];
            while(prevIdx > 0 && s.charAt(i) != s.charAt(prevIdx))
                prevIdx = lps[prevIdx - 1];

            lps[i] = prevIdx + (s.charAt(i) == s.charAt(prevIdx) ? 1:0);
        }
        return lps;
    }

    public int shortestMatchingSubstring(String s, String p) {
        int txtLen = s.length();
        int pattLen = p.length();
        if(pattLen == 2)
            return 0;

        List<Integer> starPosition = new ArrayList<>();
        for(int i = 0; i<pattLen; i++){
            if(p.charAt(i) == '*')
                starPosition.add(i);
        }

        String prefix = p.substring(0, starPosition.get(0));
        String middle = p.substring(starPosition.get(0) + 1, starPosition.get(1));
        String suffix = p.substring(starPosition.get(1) + 1, pattLen);
        int prefixLen = prefix.length();
        int middleLen = middle.length();
        int suffixLen = suffix.length();

        int[] prefixLPS = kmp(prefix + "#" + s);
        int[] middleLPS = kmp(middle + "#" + s);
        int[] suffixLPS = kmp(suffix + "#" + s);

        prefixLPS = Arrays.copyOfRange(prefixLPS, prefixLen + 1, prefixLPS.length);
        middleLPS = Arrays.copyOfRange(middleLPS, middleLen + 1, middleLPS.length);
        suffixLPS = Arrays.copyOfRange(suffixLPS, suffixLen + 1, suffixLPS.length);
        int minLen = Integer.MAX_VALUE;
        int i = 0, j = 0, k = 0;
        while(i + middleLen + suffixLen < txtLen){
            while(i < txtLen && prefixLPS[i] != prefixLen)
                i++;
            if(i >= txtLen)
                break;

            while(j<txtLen && (j<i+middleLen || middleLPS[j] != middleLen))
                j++;
            if(j>=txtLen)
                break;
            
            while(k<txtLen && (k<j + suffixLen || suffixLPS[k] != suffixLen))
                k++;
            if(k>=txtLen)
                break;

            minLen = Math.min(minLen, k - i + prefixLen);
            i++;
        }
        return minLen == Integer.MAX_VALUE? -1: minLen;

    }

}