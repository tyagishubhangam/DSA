class Solution {
    public String trimTrailingVowels(String s) {
        int n = s.length();
        int idx2 = n-1;

        while(idx2 >= 0 && isVowel(s.charAt(idx2))){
            idx2--;
        }
        if(0 > idx2){
            return "";
        }

        return s.substring(0, idx2+1);
        
    }

    public boolean isVowel(char ch){
        if(
            ch == 'a' ||
            ch == 'e' ||
            ch == 'i' ||
            ch == 'o' ||
            ch == 'u' 
        ){
            return true;
        }

        return false;
    }
}