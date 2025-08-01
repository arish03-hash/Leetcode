class Solution {
    private static final long radix1 = 26;
    private static final long mod1 = (long)1e9 + 7;
    private static final long radix2 = 27;
    private static final long mod2 = (long)1e9 + 33;

    private static Pair<Long, Long> hashPair(String str, int m){
        long hash1 = 0, hash2 = 0;
        long factor1 =  1, factor2 = 1;

        for(int i = m-1; i>=0; i--){
            hash1 = (hash1 + ((str.charAt(i) - 'a') * factor1) % mod1)%mod1;
            factor1 = (factor1 * radix1)%mod1;
            hash2 = (hash2 +((str.charAt(i) - 'a') * factor2) %mod2)%mod2;
            factor2 = (factor2 * radix2)%mod2;
        }
        return new Pair<>(hash1, hash2);
    }

    private static boolean rabinKarp(String haystack, String needle){
        int n = haystack.length();
        int p = needle.length();
        if(n < p)
            return false;

        long maxWeight1 = 1, maxWeight2 = 1;
        for(int i = 0; i<p; i++){
            maxWeight1 = (maxWeight1 * radix1)%mod1;
            maxWeight2 = (maxWeight2 * radix2) % mod2;
        }

        Pair<Long, Long> hashNeedle = hashPair(needle, p);
        Pair<Long, Long> hashHay = new Pair<>(0L, 0L);

        for(int i = 0; i<=n-p; i++){
            if(i == 0){
                hashHay = hashPair(haystack.substring(0, p), p);
            }
            else{
                long newHash1 = ((hashHay.getKey() * radix1) % mod1 - ((haystack.charAt(i-1) - 'a')*maxWeight1) % mod1 + (haystack.charAt(i + p - 1) - 'a') + mod1)%mod1;
                long newHash2 = ((hashHay.getValue() * radix2) % mod2 - ((haystack.charAt(i-1) - 'a') * maxWeight2) % mod2 + (haystack.charAt(i + p - 1) - 'a') + mod2)%mod2;
                hashHay = new Pair<>(newHash1, newHash2);
            }
            if(hashNeedle.equals(hashHay)){
                boolean match = true;
                for(int j = 0; j<p; j++){
                    if(needle.charAt(j) != haystack.charAt(i+j)){
                        match = false;
                        break;
                    }
                }
                if(match)
                    return true;
            }
        }
        return false;

    }
    public List<String> stringMatching(String[] words) {
        List<String> res = new ArrayList<>();
        int n = words.length;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(i!=j && rabinKarp(words[j], words[i])){
                    res.add(words[i]);
                    break;
                }
            }
        }
        return res;
    }
}