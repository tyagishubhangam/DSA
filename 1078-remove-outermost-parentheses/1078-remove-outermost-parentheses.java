class Solution {
    public String removeOuterParentheses(String s) {
        Stack <Character> st = new Stack<>();
        String res = "";
        int start = 0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '('){
                st.push(ch);
            }else{
                st.pop();
                if(st.size() == 0){
                   res = res+s.substring(start+1,i);
                   start = i+1;
            }
            }
           
        }
        return res;
    }
}