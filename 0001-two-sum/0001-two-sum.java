class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hs = new HashMap<>();
        int[] ans = new int[2];
        for(int i=0;i<nums.length;i++){
            int diff = target - nums[i];
            if(hs.get(diff)!= null){
                ans[0] = hs.get(diff);
                ans[1] = i;
                break;
            }
            // System.out.println(hs);
            hs.put(nums[i], i);
            
        }
        
        return ans;
    }
}