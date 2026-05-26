class Solution {
    public boolean detectCapitalUse(String word) {
        int lowCase = 0;
        int upCase = 0;
        int n = word.length();
        for(int i=0;i<n;i++){
            char ch = word.charAt(i);
            if(Character.isUpperCase(ch)){
                upCase++;
            }else{
                lowCase++;
            }
        }
        if(upCase == n || lowCase == n || (upCase == 1 && Character.isUpperCase(word.charAt(0)))){
            return true;
        }
        return false;
    }
}