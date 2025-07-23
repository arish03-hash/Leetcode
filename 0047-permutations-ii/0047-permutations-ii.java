class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        boolean[] freq = new boolean[nums.length];
        Arrays.sort(nums);
        recurPermute(nums,ans,res,freq);
        return res;
    }

    public void recurPermute(int[] nums,List<Integer> ans,List<List<Integer>> res, boolean[] freq){
        if(ans.size()==nums.length){
            res.add(new ArrayList<>(ans));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(!freq[i]){
                freq[i]  =true;
                ans.add(nums[i]);
                recurPermute(nums,ans,res,freq);
                ans.remove(ans.size()-1);
                freq[i] = false;
                while(i+1 < nums.length && nums[i] == nums[i+1])
                    i++;
            }
        }
    }
}