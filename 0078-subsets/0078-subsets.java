class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<Integer> tmp = new ArrayList<>();
        List<List<Integer>> res =new ArrayList<>();
        recurse(0,n,nums, tmp, res);
        return res;
    }

    public static void recurse(int i, int n, int[] nums, List<Integer> tmp, List<List<Integer>> res){
        if(i == n){
            res.add(new ArrayList<>(tmp));
            return;
        }
        tmp.add(nums[i]);
        recurse(i+1, n, nums,tmp, res);
        tmp.removeLast();
        recurse(i+1,n,nums, tmp, res);
    }
}