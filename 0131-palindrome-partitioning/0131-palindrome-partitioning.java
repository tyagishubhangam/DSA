class Solution {
    public List<List<String>> partition(String s) {
        int len = s.length();
        int[][] states = new int[len][len];
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                if(i>=j){
                    states[i][j] = 1;
                }
            }
        }

        for(int i=1;i<len;i++){
            int k = 0;
            int j = i;
            while(k<len && j< len){
                if(states[k+1][j-1] == 1 && (s.charAt(k) == s.charAt(j))){
                states[k][j] = 1;}
                k++;
                j++;
            }
        }
        
        List<List<String>> li = new ArrayList<>();
        List<String> tmp = new ArrayList<>();
        generatePalins(s,tmp,0,li,states);
        return li;

    }
    public static void generatePalins(String s, List<String> tmp, int i, List<List<String>> li, int[][] states){
        if(i == s.length()){
            li.add(new ArrayList<>(tmp));
            return;
        }

        for(int j = i;j<s.length();j++){
            if(isPalin(states,i,j)){
                tmp.add(s.substring(i,j+1));
                generatePalins(s,tmp,j+1,li,states);
                tmp.removeLast();
            }
        }

    }

    public static boolean isPalin(int[][] states, int i, int j){
        
        return states[i][j] == 1;
    }

    
}