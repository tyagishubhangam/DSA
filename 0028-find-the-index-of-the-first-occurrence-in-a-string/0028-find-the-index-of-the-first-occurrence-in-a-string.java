class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.length() < needle.length() ){
            return -1;
        }
        int l = 0, r = 0, p = 0;
        while(r < haystack.length() && p < needle.length()){
            if(haystack.charAt(r) == needle.charAt(p)){
                r++;
                p++;
            }else{
                r = l + 1;
                p = 0;
                l = r;
            }
        }
        if(p == needle.length()){
            return l;
        }return -1;
    }
}