class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int arr[] = new int[n];
        if(k == 0){
            return arr;
        }
        if(k>0){
        return kPositive(code, k);}
        return kNegative(code, k);
        }


        public int[] kPositive(int[] code, int k){
            int n = code.length;
            int arr[] = new int[n];
            int sum = 0, l = 0, r = 1;
            for(int i=0;i<k;i++){
            sum += code[r];
            r++;
            }
            arr[l] = sum;
            l = 1;
            while(l < n){
                // if(r >= n){
                //     r = 0;
                // }
                r = r % n;
                sum -= code[l];
                sum += code[r];
                arr[l] = sum;
                l++;
                r++;
            }
            return arr;
        }

        public int[] kNegative(int[] code, int k){
            int sum = 0;
            
            int n = code.length;
            int arr[] = new int[n];
            k = Math.abs(k);
            for(int i=n-k;i<n;i++){
                sum += code[i];
            }
            arr[0] = sum;
            int l = 0;
            int r = n-k;
            while(l<n-1){
                r = r % n;
                sum -= code[r];
                sum += code[l];
                l++;
                r++;
                arr[l] = sum;

            }
            return arr;

        }

        
    
}