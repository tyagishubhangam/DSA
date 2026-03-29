class Solution {
    public int firstMatchingIndex(String s) {
        int ans = Integer.MAX_VALUE;
        int n = s.length();
        int i = 0;
        while(i <= n/2){
            if(s.charAt(i) == s.charAt(n-i-1)){
                ans = Math.min(i, ans);
            }
            i++;
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}