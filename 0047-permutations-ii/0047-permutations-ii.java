class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> li = new ArrayList<>();
        permute(nums,0,li);
        return li;
        
    }

    public static void permute(int[] nums,int i,List<List<Integer>> li){
        if(i == nums.length-1){
            List<Integer> tmp = new ArrayList<>();
            for(int k:nums){
                tmp.add(k);
            }
            li.add(tmp);
            return;
        }
        int[] freq = new int[22];
        for(int j=i;j<nums.length;j++){
            if(freq[nums[j]+10] == 0){
                swap(nums,i,j);
                permute(nums,i+1,li);
                swap(nums,i,j);
            }
            freq[nums[j]+10]++;
        }
    }

    public static void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}