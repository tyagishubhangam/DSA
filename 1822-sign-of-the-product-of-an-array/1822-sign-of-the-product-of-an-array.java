class Solution {
    public int arraySign(int[] nums) {
        int pro = 1;
        for(int i : nums){
            if(i < 0){
                pro *= -1;
            }else{
                if(i == 0){
                    pro *= 0;
                }
            }
        }

        if(pro > 0){
            return 1;
        }else{
            if(pro < 0){
                return -1;
            }
        }
        return 0;
    }
}