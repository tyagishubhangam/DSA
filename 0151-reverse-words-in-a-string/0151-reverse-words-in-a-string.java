class Solution {
    public String reverseWords(String s) {
        String res = "";
        String tmp = "";
        s = s+ " ";
        int cntSpace = 0;
        for(int i=0;i<s.length();i++){
            
            char ch = s.charAt(i);
            if(ch == ' '){
                cntSpace++;
                if(cntSpace <=1){
                    res = tmp+ " " + res ; 
                    tmp = "";
                }
                
            }else{
                cntSpace = 0;
                tmp += ch;
            }
        }
        res = res.trim();
        return res;
    }
}