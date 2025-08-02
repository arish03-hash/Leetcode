class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int a: basket1)
            map.merge(a, 1, Integer::sum);
        for(int b : basket2)
            map.merge(b, -1, Integer::sum);

        List<Integer> swap = new ArrayList<>();
        long small = map.firstKey();
        for(int a: map.keySet()){
            if(map.get(a) % 2 != 0)
                return -1;
            int v = Math.abs(map.get(a))/2;
            for(int i = 0; i<v; i++)
                swap.add(a);
        }

        long res = 0;
        for(int i = 0; i<swap.size()/2; i++)
            res += Math.min(swap.get(i), 2*small);

        return res;
    }
}