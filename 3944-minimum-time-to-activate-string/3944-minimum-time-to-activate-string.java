class Solution {
    public int minTime(String s, int[] order, int k) {
        int n = s.length();
        TreeSet<Integer> pos = new TreeSet<>();
        pos.add(-1);
        pos.add(n);
        for(int t = 0; t<n;t++){
            int i = order[t];

            Integer r = pos.ceiling(i);
            Integer l = pos.floor(i);

            k -= (long)(i-l) * (r-i);
            pos.add(i);

            if(k<=0)
                return t;
        }
        return -1;
    }
}