class Solution {
    public boolean isSubsequence(String s, String t) {
        if(t.length() < s.length()){
            return false;
        }
        int l = 0;
        int r = 0;
        while(l<s.length() && r <t.length()){
            if(s.charAt(l) == t.charAt(r)){
                l++;
                r++;
            }else{
                r++;
            }
        }
        if(l >= s.length()){
        return true;
    }
    return false;
    }
    
}