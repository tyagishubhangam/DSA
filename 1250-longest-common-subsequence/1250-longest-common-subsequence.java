class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] mem = new int[text1.length() + 1][text2.length() + 1];
        for(int i=0;i<text1.length();i++){
            Arrays.fill(mem[i], -1);
        }
        return getAns(text1, text2, 0,0, mem);
    }

    public static int getAns(String text1, String text2, int i, int j, int[][]mem){
        if(i == text1.length() || j == text2.length()){
            return 0;
        }
        if(mem[i][j] != -1){
            return mem[i][j];
        }
        if(text1.charAt(i) == text2.charAt(j)){
            return 1 + getAns(text1, text2, i+1, j+1, mem);
        }
            return mem[i][j] = Math.max(getAns(text1, text2, i, j+1, mem),getAns(text1, text2, i+1, j, mem));
        
    }
}