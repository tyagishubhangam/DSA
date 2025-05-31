class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();
        s = s.toLowerCase();
        int i = 0;
        int j = n - 1;
        
        while(i<=j){
            boolean skip = false;
            char start = s.charAt(i);
            char end = s.charAt(j);
            if(!Character.isLetter(start) && !Character.isDigit(start)){
                i++;
                skip = true;
            }
            if(!Character.isLetter(end) && !Character.isDigit(end)){
                j--;
                skip = true;
            }
            if(skip){
                continue;
            }
            if(start != end){
                return false;
            }
            i++;
            j--;

        }

        return true;
    }
}