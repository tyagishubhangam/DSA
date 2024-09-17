class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> hs = new HashMap<>();
        HashMap<Character, Boolean> ht = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char chs = s.charAt(i);
            char cht = t.charAt(i);
            if(hs.containsKey(chs) == true){
                if(hs.get(chs) != cht){
                    return false;
                }
            }else{
                if(ht.containsKey(cht)){
                    return false;
                }
                hs.put(chs,cht);
                ht.put(cht, true);
            }
        }
        return true;
    }
}