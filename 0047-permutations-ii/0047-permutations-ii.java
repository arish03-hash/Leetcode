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

#######################################################################

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
