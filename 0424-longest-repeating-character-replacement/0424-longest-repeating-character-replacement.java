class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0, r = 0, maxLen = 0, maxFreq = 0;
        int hash[] = new int[26];
        while(r<s.length()){
            hash[s.charAt(r) - 'A'] += 1;
            maxFreq = Math.max(maxFreq,hash[s.charAt(r) - 'A']);
            if((r - l + 1) - maxFreq > k){
                hash[s.charAt(l) - 'A'] -= 1;
                maxFreq = 0;
                l++;
            }
            if((r - l + 1) - maxFreq <= k){
                maxLen = Math.max(maxLen, (r - l + 1));
            }r++;
        }
        return maxLen;
    }
}