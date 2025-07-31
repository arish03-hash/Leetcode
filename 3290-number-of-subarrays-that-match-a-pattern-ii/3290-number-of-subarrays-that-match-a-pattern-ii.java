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
    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        int n  =nums.length;
        int m = pattern.length;
        int ans = 0;
        StringBuilder sString = new StringBuilder();
        StringBuilder pString = new StringBuilder();

        for(int i = 0; i<n-1; i++){
            if(nums[i+1] > nums[i])
                sString.append('a');
            if(nums[i+1] == nums[i])
                sString.append('s');
            if(nums[i+1] < nums[i])
                sString.append('d');
        }
        for(int i = 0; i<m; i++){
            if(pattern[i] == 1)
                pString.append('a');
            if(pattern[i] == 0)
                pString.append('s');
            if(pattern[i] == -1)
                pString.append('d');
        }

        String s = pString.toString() + "#" + sString.toString();
        // System.out.println(s);
        int[] kmpVec = kmp(s);
        // for(int i  =0; i<kmpVec.length; i++)
        //     System.out.print(kmpVec[i]);
        for(int i = 2*m; i<kmpVec.length; i++)
            if(kmpVec[i] == m)
                ans++;

        return ans;
    }
}