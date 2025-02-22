class Solution {
    public int maxVowels(String s, int k) {
        int l = 0;
        int count = 0;
        int maxCount = 0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(isVowel(ch)){
                count += 1;
            }

            if(i - l + 1 > k){
                char pre = s.charAt(l);
                if(isVowel(pre)){
                    count -= 1;
                }
                
                l++;
            }
            maxCount = Math.max(count, maxCount);
        }
         return maxCount;

    }

    public static boolean isVowel(char ch){
        if(
            ch == 'a' ||
            ch == 'e' ||
            ch == 'i' ||
            ch == 'o' ||
            ch == 'u' 
        ){
            return true;
        }

        return false;
    }
}