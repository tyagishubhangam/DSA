class Solution {
    public boolean doesAliceWin(String s) {
        int n = s.length();

        // Vowels ke index ke liye maine yeh liya hai
        int lastVowelIndex = -1;
        int cntVowels = 0;
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(
                ch == 'a' ||
                ch == 'e' ||
                ch == 'i' ||
                ch == 'o' ||
                ch == 'u' 
            ){
                lastVowelIndex = i;
                cntVowels++;
            }
        }

        // agar mera vowels count is odd
        
        if(cntVowels == 0){
            return false;
        }
        if(cntVowels % 2 != 0){
            return true;
        }
        
        int strLeft = n - lastVowelIndex;
        if(strLeft > 1){
            return true;
        }
        if(lastVowelIndex == n-1){
            return true;
        }
        return false;
        
    }

    
}

