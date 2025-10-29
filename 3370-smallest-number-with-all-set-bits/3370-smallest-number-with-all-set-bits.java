class Solution {
    public int smallestNumber(int n) {
        String binary = Integer.toBinaryString(n);
        int ans = 0;
        // System.out.println(binary);
        for(int i=0;i<binary.length();i++){
            ans += Math.pow(2,i);
        }
        return ans;
    }
}