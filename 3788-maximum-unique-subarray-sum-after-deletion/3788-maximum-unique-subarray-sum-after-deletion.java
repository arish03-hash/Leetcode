class Solution {
    public int maxSum(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int maxNeg = Integer.MIN_VALUE;
        int sum = 0;
        for(int n: nums){
            if(n > 0)
                set.add(n);
            else
                maxNeg = Math.max(maxNeg, n);
        }
        for(int i: set){
            sum += i;
        }
        if(set.size() > 0)
            return sum;
        else
            return maxNeg;
    }
}