class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        int n = text.length();
        HashSet<Character> hs = new HashSet<>();
        for(int i=0;i<brokenLetters.length();i++){
            hs.add(brokenLetters.charAt(i));
        }
        text += ' ';
        boolean isValid = true;
        int cnt = 0;
        for(int i=0;i<=n;i++){
            char ch = text.charAt(i);
            if(ch == ' '){
                if(isValid){
                    cnt++;
                }
                isValid = true;
            }else{
                if(hs.contains(ch)){
                    isValid = false;
                }
            }
        }

        return cnt;
        
    }
}