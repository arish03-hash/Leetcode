class Solution {
    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        int n = nums.length;
        int m = pattern.length;
        int ans = 0;

        for(int i = 0; i<n-m; i++){
            int flag = 1;
            // if(i + m >= n)
            //     break;
            for(int j = i; j-i < m && j + 1<n ;j++){
                if((pattern[j - i] == -1) && (nums[j] > nums[j + 1]))
                    continue;
                if((pattern[j - i] == 0) && (nums[j] == nums[j + 1]))
                    continue;
                if((pattern[j - i] == 1) && (nums[j] < nums[j + 1]))
                    continue;    
                flag = 0;
                break;
            }
            if(flag == 1)
                ans++;
        }
        return ans;
    }
}