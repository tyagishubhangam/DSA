class Solution {
    public String longestCommonPrefix(String[] strs) {
        String res = "";
        int index = 0;
        boolean temp = false;
        int minLength = strs[0].length();
        if(strs.length == 1){
            return strs[0];
        }
        for(int i=0;i<strs.length;i++){
            if(minLength > strs[i].length()){
                minLength = strs[i].length();
                index = i;
            }
        }
        for(int j=0;j<minLength;j++){
            for(int k=0;k<strs.length;k++){
                if(k != index){
                    if(strs[k].charAt(j) == strs[index].charAt(j)){
                        temp = true;
                    }else{
                        temp = false;
                        break;
                    }

                }
            }
            if(temp){
                res += strs[index].charAt(j);
            }else{
                break;
            }
        }

        return res;
    }
}