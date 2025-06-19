class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int[] str = {0,0,0};
        // HashMap<Character, Integer> hs = new HashMap<>();
        int l = 0;
        int r = 0;
        int ans = 0;
        while(r<n){
            char chAdd = s.charAt(r);
            str[chAdd - 'a']++;
            
            
            while(str[0] > 0 && str[1] > 0 && str[2] > 0){
                char chRem = s.charAt(l);
                ans += (n - r);
                str[chRem - 'a']--;
                
                l++;
            }
            r++;
        }
        return ans;

    }
}