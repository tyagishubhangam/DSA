class Solution {
    public List<String> letterCombinations(String digits) {
        
        String[] arr = new String[10];
        arr[2] = "abc";
        arr[3] = "def";
        arr[4] = "ghi";
        arr[5] = "jkl";
        arr[6] = "mno";
        arr[7] = "pqrs";
        arr[8] = "tuv";
        arr[9] = "wxyz";
        List<String> li = new ArrayList<>();
        if(digits.length() == 0){
            return li;
        }
        generateCombos("",digits,0,arr,li);
        return li;
    }

    public static void generateCombos(String tmp,String s, int idx, String[] arr,List<String> li){
        if(idx == s.length()){
            li.add(tmp);
            return;
        }
        int x = Integer.parseInt(s.substring(idx,idx+1));
        String letters = arr[x];
        for(int i=0;i<letters.length();i++){
            generateCombos(tmp+letters.charAt(i),s,idx + 1,arr,li);
        }

    }
}