class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length;
        if(bits[n-1] == 1){
            return false;
        }
        int r = 0;
        while(r < n){
            if(bits[r] == 0){
                r++;
            }else{
                r+= 2;
                if(r >= n){
                    return false;
                }
            }
        }
        return true;

    }
}