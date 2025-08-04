class Solution {
    public int longestNiceSubarray(int[] nums) {
        int n = nums.length;
        int l = 0, r=0, cur = 0, ans = 0; 
        for(r= 0; r<n; r++){
            while((cur&nums[r])!=0)
                cur ^= nums[l++];

            cur |= nums[r];
            ans = Math.max(ans, r-l+1);
        }
        return ans;
    }
}