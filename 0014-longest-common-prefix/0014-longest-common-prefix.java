class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 1){
            return strs[0];
        }
        boolean temp = true;
        String res = "";
        for(int i=0;i<strs[0].length();i++){
            char ch = strs[0].charAt(i);
            for(int j=1;j<strs.length;j++){
                if(i>=strs[j].length() || ch != strs[j].charAt(i)){
                    temp = false;
                    break;
                }
            }
            if(temp){
                res += ch;
            }else{
                break;
            }
        }
        return res;
    }
}