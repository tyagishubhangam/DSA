class Solution {
    public int countSeniors(String[] details) {
        int cnt= 0;
        for(String s : details){
            int n = s.length();
            if(s.charAt(n-4) > '6' || (s.charAt(n-4) == '6' && s.charAt(n-3) > '0')){
                cnt++;
            }
        }
        return cnt;
    }
}