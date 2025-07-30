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
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        String sa = a + "#" + s;
        String sb = b + "#" + s;
        List<Integer> va = new ArrayList<>();
        List<Integer> vb = new ArrayList<>();

        int[] v = kmp(sa);
        for(int i = a.length(); i<v.length; i++){
            int el = v[i];
            if(el == a.length()){
                int id = i - 2 * a.length();
                if(id >=0)
                    va.add(id);
            }
        }
        v = kmp(sb);
        for(int i = b.length(); i<v.length; i++){
            int el = v[i];
            if(el == b.length()){
                int id = i - 2 * b.length();
                if(id >=0)
                    vb.add(id);
            }
        }

        List<Integer> ans = new ArrayList<>();
        if(va.isEmpty() || vb.isEmpty())
            return ans;

        for(int i = 0; i<va.size(); i++){
            int idx = Collections.binarySearch(vb, va.get(i));
            if(idx < 0)
                idx = -(idx + 1);
            
            if(idx < vb.size() && Math.abs(va.get(i) - vb.get(idx)) <= k){
                ans.add(va.get(i));
                continue;
            }
            if(idx > 0 && Math.abs(va.get(i) - vb.get(idx - 1)) <= k)
                ans.add(va.get(i));
        }
        return ans;
    }
}