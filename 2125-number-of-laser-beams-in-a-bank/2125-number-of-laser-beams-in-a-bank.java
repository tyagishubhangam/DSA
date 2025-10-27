class Solution {
    public int numberOfBeams(String[] bank) {
        int n = bank.length;
        int prev = 0;
        int ans = 0;
        for(String s : bank){
            int curr = 0;
            for(int i=0;i<s.length();i++){
                curr += (s.charAt(i) - '0');
            }
            if(curr != 0){
                ans += (prev * curr);
                prev = curr;
            }
        }
        return ans;
    }
}