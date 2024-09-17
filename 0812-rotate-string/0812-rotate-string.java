class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()){
            return false;
        }
        if(s.equals(goal)){
            return true;
        }
        String temp = s;
        for(int i=1;i<s.length();i++){
            temp = temp.substring(1,s.length()) + temp.charAt(0);
            // System.out.println(temp);
            if(temp.equals(goal)){
                return true;
            }
        }return false;
    }
}