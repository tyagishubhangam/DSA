class Solution {
    public String largestOddNumber(String num) {
        for(int i = num.length()-1;i>=0;i--){
            int tmp = Character.valueOf(num.charAt(i));
            if(tmp % 2 != 0){
                num = num.substring(0,i+1);
                break;

            }else{
                if(i == 0){
                   num =  "";
                }
            }
        }
        return num;
    }
}