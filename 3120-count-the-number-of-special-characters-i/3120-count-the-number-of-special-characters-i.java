class Solution {
    public int numberOfSpecialChars(String word) {
        HashSet<Character> hsUp = new HashSet<>();
        HashSet<Character> hsLow = new HashSet<>();
        int n = word.length();
        for(int i=0;i<n;i++){
            char ch = word.charAt(i);
            if(Character.isUpperCase(ch)){
                hsUp.add(ch);
            }else{
                hsLow.add(ch);
            }
        }
        int cnt = 0;
        for(char ch : hsUp){
            if (hsLow.contains(Character.toLowerCase(ch))){
                cnt++;
            }
        }

        return cnt;
    }
}