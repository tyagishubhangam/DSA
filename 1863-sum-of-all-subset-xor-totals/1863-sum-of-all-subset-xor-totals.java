class Solution {
    public int subsetXORSum(int[] nums) {
        List<List<Integer>> li = new ArrayList<>();
        recurse(0,nums, li, new ArrayList<>());
        int sum = 0;
        for(List<Integer> tmp : li){
            int XOR = 0;
            for(int i : tmp){
                XOR ^= i;
            }
            sum += XOR;
        }
        return sum;

        
    }
    public void recurse(int i, int[] nums, List<List<Integer>> li, List<Integer> tmp){
        if(i >= nums.length){
            li.add(new ArrayList<>(tmp));
            return ;
        }
        tmp.add(nums[i]);
        int idx = tmp.size();
        recurse(i+1, nums, li, tmp);
        tmp.remove(idx-1);
        recurse(i+1, nums, li, tmp);


    }

    
}