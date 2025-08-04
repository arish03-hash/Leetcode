class Solution {
    public int totalFruit(int[] fruits) {
        int l = 0, r = 0, max = Integer.MIN_VALUE;
        int n = fruits.length;
        HashMap<Integer, Integer> map=  new HashMap<>();
        while(r<n){
            map.merge(fruits[r], 1, Integer::sum);
            if(map.size() > 2){
                map.put(fruits[l], map.get(fruits[l]) - 1);
                if(map.get(fruits[l]) == 0)
                    map.remove(fruits[l]);
                l++;
            }
            else{
                max = Math.max(max, r - l + 1);
            }
            r++;
        }
        return max;
    }
}