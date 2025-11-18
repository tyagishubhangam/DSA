class Solution {
    public boolean validPalindrome(String s) {
        int n = s.length();
        int l = 0;
        int r = n - 1;
        
        while(l <= r){
            if(s.charAt(l) == s.charAt(r)){
                l++;
                r--;
            }else{
                boolean c1 = isPalin(l, r-1, s);
                boolean c2 = isPalin(l+1,r,s);
                if(c1 && !c2){
                    r--;
                }else{
                    if(c2 && !c1){
                        l++;
                    }else{
                        if(!c1 && !c2){
                            return false;
                        }else{
                            r--;
                        }
                    }
                }
            }
        }
        
        return true;
    }

    public boolean isPalin(int l, int r, String s){
        while(l <= r){
            if(s.charAt(r) == s.charAt(l)){
                l++;
                r--;
            }else{
                return false;
            }
        }
        return true;
    }
}