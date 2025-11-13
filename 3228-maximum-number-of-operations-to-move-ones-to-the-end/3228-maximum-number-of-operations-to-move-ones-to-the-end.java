class Solution {
    public int maxOperations(String s) {
        int n = s.length();
        // s += " ";
        int cnt = 0;
        int ops = 0;
        for(int i=0;i<n;i++){
            if(s.charAt(i) == '1'){
                cnt++;
            }else{
                
                if(i+1 >= n || s.charAt(i+1) == '1' && s.charAt(i) == '0'){
                    ops += cnt;
                }
            }
        }

        return ops;
    }
}