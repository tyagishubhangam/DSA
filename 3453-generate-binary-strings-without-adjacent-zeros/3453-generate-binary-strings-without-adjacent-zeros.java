class Solution {
    public List<String> validStrings(int n) {
        List<String> li = new ArrayList<>();
        helper(0,"",li,n);
        return li;
    }


    public static void helper(int idx, String st, List<String> li, int n){
        if(idx == n){
            li.add(st);
            return ;
        }
        if(idx == 0){
            helper(idx+1, st+"0", li, n);
        }

        if(idx != 0 && st.charAt(idx-1) != '0'){
            helper(idx + 1, st + "0",li,n);
        }
        helper(idx+1, st + "1", li, n);
    }
}