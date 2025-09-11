class Solution {
    public String sortVowels(String s) {
        int n = s.length();
    //    List<int[]> cons = new ArrayList<>();
    StringBuilder str = new StringBuilder();
       List<Character> vowels = new ArrayList<>();
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(isVowel(ch)){
                str.append('_');
                vowels.add(ch);
            }else{
                str.append(ch);
            }
        }
        Collections.sort(vowels);
        int idx = 0;
        for(int i=0;i<n;i++){
            char ch = str.charAt(i);
            if(ch == '_'){
                str.setCharAt(i,vowels.get(idx++));
            }
        }
        return str.toString();

        
        
    }

    public boolean isVowel(char ch){
        if(
            ch == 'a' ||
            ch == 'e' ||
            ch == 'i' ||
            ch == 'o' ||
            ch == 'u' ||
            ch == 'A' ||
            ch == 'E' ||
            ch == 'I' ||
            ch == 'O' ||
            ch == 'U' ){
            return true;
        }
        return false;
    }
}