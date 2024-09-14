class Solution {
    public String reverseWords(String s) {
        s = ' ' + s.trim();
        StringBuilder res = new StringBuilder();
        String temp = "";
        for(int i = s.length()-1;i>=0;i--){
            char ch = s.charAt(i);
            if(ch != ' '){
                temp = ch+temp;
            }else{
                if(temp!="")
               { res.append(temp+' ');}
                temp = "";
            }
        }
        return res.toString().trim();
        
    }
}