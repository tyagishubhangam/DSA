class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> st = new ArrayList<>();
        char[] ch = new char[2*n];
        getAns(n,0,0,0,ch,st);
        return st;
    }

    public static void getAns(int n, int l, int r, int i, char[] ch,List<String> li){
        if(i == (2*n)){
            String s = "";
            for(char k : ch){
                s+=k;
            }
            li.add(s);
            return;
        }

        if(l == r){
            ch[i] = '(';
            getAns(n,l+1,r,i+1,ch,li);
        }else{
            if(l>r){
                if(l == n){
                ch[i] = ')';
                getAns(n,l,r+1,i+1,ch,li);}
            else{
                ch[i] = '(';
                getAns(n,l+1,r,i+1,ch,li);
                ch[i] = ')';
                getAns(n,l,r+1,i+1,ch,li);
                }
            }
        }
    }
}    