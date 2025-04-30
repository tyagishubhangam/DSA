class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for(int i:nums){
            if(countDigits(i)){
                count++;
            }
        }
        return count;
    }

    public static boolean countDigits(int n){
        int c = 0;
        while(n != 0){
            c++;
            n = n/10;
        }
        return c%2 == 0?true:false;
    }
}