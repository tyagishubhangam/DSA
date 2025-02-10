class Solution {
    public boolean divideArray(int[] nums) {
        int[] freq = new int[501];
        for(int i=0;i<nums.length;i++){
            freq[nums[i]] += 1;
            
        }
        int gcd = getGCD(freq[0], freq[1]);
        for(int i=2;i<501;i++){
            
            gcd = getGCD(gcd, freq[i]);
            
        }
        if(gcd > 1){
            return true;
        }
        return false;

    }

    public static int getGCD(int n1, int n2){
        int min = Math.min(n1, n2);
        int max = Math.max(n1, n2);
        if(min == 0){
            return max;
        }
        while(max % min != 0){
            int tmp = min;
             min = max % min;
             max = tmp;
        }
        return min;
    }
}