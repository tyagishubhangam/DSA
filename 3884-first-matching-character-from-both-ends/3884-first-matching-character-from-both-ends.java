class Solution {
    public int firstMatchingIndex(String s) {
        int n = s.length();
        int i = 0;
        while(i <= n/2){
            if(s.charAt(i) == s.charAt(n-i-1)){
                return i;
            }
            i++;
        }
        return -1;
    }
}