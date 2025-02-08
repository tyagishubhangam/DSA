class Solution {
    public int findGCD(int[] nums) {
        int minNum = Integer.MAX_VALUE;
        int maxNum = Integer.MIN_VALUE;
        for(int i : nums){
            minNum = Math.min(minNum, i);
            maxNum = Math.max(maxNum, i);
        }

        while(maxNum % minNum != 0){
            int tmp = minNum;
            minNum = maxNum % minNum;
            maxNum = tmp;
        }
        return minNum;
    }
}