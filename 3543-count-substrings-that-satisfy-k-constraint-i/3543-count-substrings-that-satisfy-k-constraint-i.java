class Solution {
    public int countKConstraintSubstrings(String s, int k) {
       
        int result = 0;
        for(int i=0;i<s.length();i++){
            int countZero = 0;
            int countOne = 0;
            for(int j=i;j<s.length();j++){
                if(s.charAt(j) == '0'){
                    countZero++;
                }else if(s.charAt(j) == '1'){
                    countOne++;
                }
                if(countZero <= k || countOne <= k){
                    result++;
                }else{
                   break;
                }
            }
        }
        return result;
    }
}