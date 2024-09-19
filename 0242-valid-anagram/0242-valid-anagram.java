class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int arrs[] = new int[26];
        // int arrt[] = new int[26];
        for(int i=0;i<s.length();i++){
            int cs = (int)s.charAt(i) -97;
            int ct = (int)t.charAt(i) -97;
            arrs[cs] +=1;
            arrs[ct] -=1;
        }
        for(int j=0;j<26;j++){
            if(arrs[j] >0){
                return false;
            }
        }
        return true;
    }
}