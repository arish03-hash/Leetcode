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