class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> li = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        generateAns(tmp, 0, li, nums);
        return li;
    }

    public static void generateAns(List<Integer> tmp, int idx, List<List<Integer>> li, int[] nums){
        if(idx == nums.length){
            li.add(new ArrayList<>(tmp));
            return;
        }

        tmp.add(nums[idx]);
        generateAns(tmp, idx + 1, li, nums);
        tmp.removeLast();
        generateAns(tmp,idx + 1, li, nums);
    }
}