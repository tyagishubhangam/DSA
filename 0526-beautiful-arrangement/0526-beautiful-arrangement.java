class Solution {
    public int countArrangement(int n) {
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = i+1;
        }
        return getAns(arr,0);

    }
    public static int getAns(int[] arr, int i){
        if(i == arr.length){
            return 1;
        }

        int ans = 0;
        for(int j=i;j<arr.length;j++){
            if((i+1)%arr[j] == 0 || arr[j] % (i+1) ==0){
                swap(arr,i,j);
                ans+= getAns(arr,i+1);
                swap(arr,i,j);
            }
        }
        return ans;
    }

    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}