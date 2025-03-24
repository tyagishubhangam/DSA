class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> li = new ArrayList<>();
        List<String> tmp = new ArrayList<>();
        generatePalins(s,tmp,0,li);
        return li;

    }
    public static void generatePalins(String s, List<String> tmp, int i, List<List<String>> li){
        if(i == s.length()){
            li.add(new ArrayList<>(tmp));
            return;
        }

        for(int j = i;j<s.length();j++){
            if(isPalin(s,i,j)){
                tmp.add(s.substring(i,j+1));
                generatePalins(s,tmp,j+1,li);
                tmp.removeLast();
            }
        }

    }

    public static boolean isPalin(String s, int i, int j){
        while(i<=j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}