class Solution {
    public int numberOfSpecialChars(String word) {
        int n = word.length();
        int[] upIdxs = new int[26];
        int[] tmp = new int[26];
        for(int i=0;i<n;i++){
            char ch = word.charAt(i);
            if(Character.isUpperCase(ch)){
                if(upIdxs[ch - 'A'] == 0){
                    upIdxs[ch - 'A'] = i+1;
                }
            }
        }

        for(int i=0;i<n;i++){
            char ch = word.charAt(i);
            if(Character.isLowerCase(ch)){
                char upCh = Character.toUpperCase(ch);
                if(upIdxs[upCh - 'A'] != 0 && (i+1) < upIdxs[upCh - 'A']){
                    tmp[ch - 'a'] = 1;
                }else{
                    tmp[ch - 'a'] = 0;
                }
            }
        }
        int ans = 0;
        for(int i : tmp){
            ans += i;
        }

        return ans;
    }
}