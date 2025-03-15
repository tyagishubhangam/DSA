class Solution {
    public char kthCharacter(int k) {
       String res = compute("a",k);
       return res.charAt(k-1);
    }

    public static String compute(String wrd, int k){
        if(wrd.length()>=k){
            return wrd;
        }
        String tmp = "";
        for(int i=0;i<wrd.length();i++){
            if(wrd.charAt(i) == 'z'){
                tmp += 'a';
            }else{
                tmp += (char)((int)wrd.charAt(i) + 1);
            }
        }
        

        return compute(wrd+tmp, k);
    }
}