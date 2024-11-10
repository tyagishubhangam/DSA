class Solution {
    public int numberOfAlternatingGroups(int[] colors) {
        int result = 0;
        for(int i=0;i<=colors.length-3;i++){
            if(
                colors[i] == colors[i+2] 
                && 
                colors[i] != colors[i+1]
            ){
                result++;
            }
        }
        if(
            colors[colors.length -1] == colors[1]
            &&
            colors[1] != colors[0]
        ){
            result++;
        }
            if(colors[colors.length - 2] == colors[0] && colors[0] != colors[colors.length -1]){
                result++;
            }
        
        return result;
    }
}