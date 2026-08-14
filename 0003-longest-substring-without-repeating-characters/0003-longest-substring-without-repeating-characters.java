class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        HashMap<Character,Integer> hs = new HashMap<>();
        int maxLen = 0;
        int l = 0;
        int r = 0;
        while(r < n){
            char ch = s.charAt(r);
            hs.put(ch, hs.getOrDefault(ch, 0) + 1);
            while(l < r && hs.get(ch) > 1){
                char chRem = s.charAt(l);
                hs.put(chRem, hs.get(chRem) - 1);
                if(hs.get(chRem) == 0){
                    hs.remove(chRem);
                }
                l++;
            }
            if(hs.size() == (r - l + 1)){
                maxLen = Math.max(maxLen, (r - l + 1));
            }
            r++;
        }

        return maxLen;
    }
}