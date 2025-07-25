class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char ch: s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        pq.addAll(map.entrySet());

        StringBuilder res = new StringBuilder();
        while(!pq.isEmpty()){
            Map.Entry<Character, Integer> ent = pq.poll();
            res.append(String.valueOf(ent.getKey()).repeat(ent.getValue()));
        }
        return res.toString();
    }
}