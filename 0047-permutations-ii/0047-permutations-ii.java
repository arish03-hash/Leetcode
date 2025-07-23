class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        recurPermute(0,nums,res);
        return res;
    }

    public void recurPermute(int ind,int[] nums,List<List<Integer>> res){
        if(ind==nums.length){
            List<Integer> ans = new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                ans.add(nums[i]);
            }
            if(!res.contains(ans))
                res.add(new ArrayList<>(ans));
            return;
        }

        for(int i=ind;i<nums.length;i++){
                swap(i,ind,nums);
                recurPermute(ind+1,nums,res);
                swap(i,ind,nums);

        }  
    }
    private void swap(int i, int j, int[] nums){
        // nums[i] = nums[i] ^ nums[j];
        // nums[j] = nums[i] ^ nums[j];
        // nums[i] = nums[i] ^ nums[j];
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}