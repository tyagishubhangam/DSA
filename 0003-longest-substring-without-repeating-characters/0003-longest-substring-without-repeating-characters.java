class Solution {
    public int lengthOfLongestSubstring(String s) {
        int hash[] = new int[256];
        Arrays.fill(hash, -1);
        int l = 0, r = 0, maxLen = 0;
        int n = s.length();
        while(r < n){
            if(hash[s.charAt(r)] != -1){
                if(hash[s.charAt(r)] >= l){
                    l = hash[s.charAt(r)] + 1;
                }
            }
            int len = r - l + 1;
            maxLen = Math.max(maxLen, len);
            hash[s.charAt(r)] = r;
            r += 1;
        }
        return maxLen;
    }
}