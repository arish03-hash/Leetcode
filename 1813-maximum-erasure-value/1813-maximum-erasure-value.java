class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int maxScore = 0, currScore = 0;

        HashSet<Integer> set = new HashSet<>();
        for(int l = 0, r = 0; r<nums.length; r++){
            while(!set.add(nums[r])){
                currScore -= nums[l];
                set.remove(nums[l++]);
            }
            currScore += nums[r];
            maxScore = Math.max(currScore, maxScore);
        }
        return maxScore;
    }
}

##################################################################################

class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] prefixSum = new int[nums.length + 1];
        int maxScore = 0;
        for(int l = 0, r = 0; r<nums.length; r++){
            prefixSum[r+1] = prefixSum[r] + nums[r];
            if(map.containsKey(nums[r])){
                l = Math.max(l, map.get(nums[r]) + 1);
            }
            maxScore = Math.max(maxScore, prefixSum[r+1] - prefixSum[l]);
            map.put(nums[r], r);
        }
        return maxScore;
    }
}
