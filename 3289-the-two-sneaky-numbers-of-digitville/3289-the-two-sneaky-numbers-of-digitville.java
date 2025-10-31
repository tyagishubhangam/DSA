class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int n = nums.length;
        HashSet<Integer> hs = new HashSet<>();
        int[] ans = new int[2];
        int idx = 0;
        for(int i=0;i<n;i++){
            if(hs.contains(nums[i])){
                ans[idx++] = nums[i];
            }
            hs.add(nums[i]);
            if(idx == 2){
                break;
            }
        }
        return ans;
    }
}