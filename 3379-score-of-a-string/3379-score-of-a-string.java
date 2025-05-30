class Solution {
    public int scoreOfString(String s) {
        int n = s.length();
        int res = 0;
        for(int i=0;i<n-1;i++){
            char a = s.charAt(i);
            char b = s.charAt(i+1);
            res += Math.abs(a - b);
        }

        return res;
    }
}