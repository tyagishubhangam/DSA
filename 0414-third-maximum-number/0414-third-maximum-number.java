class Solution {
    public int thirdMax(int[] nums) {
        int n = nums.length;
        int tmp = nums[0];
        int minTmp = nums[0];
        for(int i=0;i<n;i++){
            tmp = Math.max(tmp, nums[i]);
            minTmp = Math.min(minTmp, nums[i]);
        }

        int tmp2 = minTmp;
        Integer ans = null;

        for(int i=0;i<n;i++){
            if(nums[i] != tmp){
                System.out.println(tmp2);
                if(tmp2 < nums[i]){
                    ans = tmp2;
                    tmp2 = nums[i];
                }else{
                    if(nums[i] != tmp2 && ans != null){
                        ans = Math.max(ans, nums[i]);
                    }
                    
                }
            }
        }

        if(ans == null){
            return tmp;
        }


        


        return ans ;
    }
}