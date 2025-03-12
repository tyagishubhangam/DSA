class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        getPermutations(0,nums,ans);
        return ans;
    }

    public static void  getPermutations(int i, int[] nums, List<List<Integer>> ans){
        if(i == nums.length){
            List<Integer> li = new ArrayList<>();
            for(int k:nums){
                li.add(k);
            }
            ans.add(li);
            return;
        }

        for(int j=i;j<nums.length;j++){
            swap(i,j,nums);
            getPermutations(i+1,nums,ans);
            swap(i,j,nums);
        }
    }

    public static void swap(int x, int y, int[] nums){
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }
}