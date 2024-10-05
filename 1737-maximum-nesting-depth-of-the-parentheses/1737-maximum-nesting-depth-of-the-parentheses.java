class Solution {
    public int maxDepth(String s) {
        int st1 = 0;
        int st2 = 0;
        int res = 0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '('){
                st1++;
            }else{
                if(ch == ')'){
                    st2++;
                }
            }
            res = Math.max(res, (st1-st2));
        }
        return res;
    }
}