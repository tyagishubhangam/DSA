class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> li = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        getSubsets(temp, 0, li, nums);
        return li;

    }

    public static void getSubsets(List<Integer> tmp,int idx, List<List<Integer>> li,int[] nums){

        if(idx == nums.length){
            li.add(new ArrayList<>(tmp));
            return;
        }

        tmp.add(nums[idx]);
        getSubsets(tmp,idx + 1, li, nums);

        tmp.removeLast();
        getSubsets(tmp,idx + 1, li, nums);

    }

    
}