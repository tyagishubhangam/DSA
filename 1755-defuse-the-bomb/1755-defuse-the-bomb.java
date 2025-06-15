class Solution {
    public int[] decrypt(int[] code, int k) {
        int[] ans = new int[code.length];
        if(k == 0){
            return ans;
        }
        int n = code.length;
        int[] preSumLeft = new int[n+Math.abs(k)];
        int[] preSumRight = new int[n+Math.abs(k)];
        preSumRight[0] = code[0];
        preSumLeft[0] = code[n - Math.abs(k)];


        for(int i=1;i<preSumRight.length;i++){
            if(i<code.length){
                preSumRight[i] += preSumRight[i-1] + code[i];
            }else{
                if(i>=code.length){
                    preSumRight[i] += preSumRight[i-1] + code[i-code.length]; 
                }
            }

            if(i<Math.abs(k)){
                preSumLeft[i] = preSumLeft[i - 1] + code[n - Math.abs(k) + i];
            }else{
                if(i>=Math.abs(k)){
                    preSumLeft[i] = preSumLeft[i - 1] + code[i - Math.abs(k)]; 
                }
            }
        }


        if(k>0){
            for(int i = 0;i<n;i++){
                ans[i] = preSumRight[i+k] - preSumRight[i];
            }
            // return ans;
        }else{
            for(int i=0;i<n;i++){
                if(i == 0){
                    ans[i] = preSumLeft[i+Math.abs(k)] - code[i];
                }else{
                    ans[i] = preSumLeft[i+Math.abs(k)] - preSumLeft[i - 1] - code[i];
                }
            }
        }
        
        return ans;
    }
}