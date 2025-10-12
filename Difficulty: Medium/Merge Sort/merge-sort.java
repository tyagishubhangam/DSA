class Solution {

    void mergeSort(int arr[], int l, int r) {
        // code here
        if(l  == r){
            return ;
        }
        int mid = l + (r - l) / 2;
        mergeSort(arr, l, mid);
        mergeSort(arr,mid + 1, r);
        merge(arr, l, mid, r);
        
    }
    
    public void merge(int[] arr, int l, int m, int r){
        int s1 = m - l + 1;
        int s2 = r - m ;
        int[] left = new int[s1];
        int[] right = new int[s2];
        int k = l;
        for(int i=0;i<s1;i++){
            left[i] = arr[k];
            k++;
        }
        for(int i=0;i<s2;i++){
            right[i] = arr[k];
            k++;
        }
        int i = 0;
        int j = 0;
        int idx = l;
        while(i < s1 && j < s2){
            if(left[i] <= right[j]){
                arr[idx] = left[i];
                i++;
            }else{
                arr[idx] = right[j];
                j++;
            }
            idx++;
        }
        while(i < s1){
            arr[idx] = left[i];
            i++;
            idx++;
        }
        
        while(j < s2){
            arr[idx] = right[j];
            idx++;
            j++;
        }
    }
}