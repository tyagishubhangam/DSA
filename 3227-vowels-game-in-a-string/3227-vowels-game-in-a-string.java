class Solution {
    public boolean doesAliceWin(String s) {
        int n = s.length();

        // Vowels ke index ke liye maine yeh liya hai
        List<Integer> vowels = new ArrayList<>();
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(
                ch == 'a' ||
                ch == 'e' ||
                ch == 'i' ||
                ch == 'o' ||
                ch == 'u' 
            ){
                vowels.add(i);
            }
        }

        // agar mera vowels count is odd
        int cntVowels = vowels.size();
        if(cntVowels == 0){
            return false;
        }
        if(cntVowels % 2 != 0){
            return true;
        }
        int lastVowelIndex = vowels.get(cntVowels-1);
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

