class Solution {
    public int countGoodSubstrings(String s) {
        int i = 0;
        int result = 0;
        while(i<s.length()-2){
            if(isGood(s.substring(i,i+3))){
                result++;
                
            }
            i++;
        }
        return result;


    }
    public boolean isGood(String str){
        HashSet<Character> hs = new HashSet<>();
        hs.add(str.charAt(0));
        hs.add(str.charAt(1));
        hs.add(str.charAt(2));
        if(hs.size() == 3){
            return true;
        }
        return false;
    }
}