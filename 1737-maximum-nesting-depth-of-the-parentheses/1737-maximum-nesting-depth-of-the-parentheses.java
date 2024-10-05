class Solution {
    public int maxDepth(String s) {
        Stack<Character> st1 = new Stack<>();
        Stack<Character> st2 = new Stack<>();
        int res = 0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '('){
                st1.push(ch);
            }else{
                if(ch == ')'){
                    st2.push(ch);
                }
            }
            res = Math.max(res, (st1.size()-st2.size()));
        }
        return res;
    }
}