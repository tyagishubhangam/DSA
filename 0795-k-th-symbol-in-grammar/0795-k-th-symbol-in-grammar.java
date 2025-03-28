class Solution {
    public int kthGrammar(int n, int k) {
        int r =(int) Math.pow(2,n-1);
        return getAns(1,r,0,k);
    }

    public static int getAns(int l, int r, int str,int k){
        if(l == r){
            return str;
        }
        

        if(str == 1){
            if((l+r)/2 >= k){
                return getAns(l, (l+r)/2, 1, k);
            }else{
                return getAns((l+r)/2 + 1, r, 0, k);
            }
        }else{
            if((l+r)/2 >= k){
                return getAns(l,(l+r)/2,0,k);
            }else{
                return getAns((l+r)/2 + 1, r, 1, k);
            }
        }
        // return str;
    }
}