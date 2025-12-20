class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int idx = 0;
        int cnt = 0;
        while(idx < strs[0].length()){
            for(int i=1;i<n;i++){
                if(strs[i-1].charAt(idx) > strs[i].charAt(idx)){
                    cnt++;
                    break;
                }
            }
            idx++;
        }

        return cnt;
    }
}