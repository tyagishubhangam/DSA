class Solution {
    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        s = s.toLowerCase();
        boolean res = true;
        // if(s.length() == 1){
        //     return true;
        // }
        while(l <= r){
            char chl = s.charAt(l);
            char chr = s.charAt(r);
            if(Character.isDigit(chl) == false && Character.isLetter(chl) == false ){
                l++;
                continue;
            }  if(Character.isDigit(chr) == false && Character.isLetter(chr) == false ){
                r--;
                continue;
            }
            if(chr == chl){
                res = true;
                r--;
                l++;
            }else{
                res = false;
                break;
            }
            
        }
        return res;
        
    }
}