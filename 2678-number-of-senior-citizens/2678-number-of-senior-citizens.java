class Solution {
    public int countSeniors(String[] details) {
        int cnt= 0;
        for(String s : details){
            if(Integer.parseInt(s.substring(s.length()-4, s.length()-2)) > 60){
                cnt++;
            }
        }
        return cnt;
    }
}