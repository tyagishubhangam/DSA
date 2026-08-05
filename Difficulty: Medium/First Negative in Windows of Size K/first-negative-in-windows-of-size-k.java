class Solution {
    static List<Integer> firstNegInt(int arr[], int k) {
        // code here
        int n = arr.length;
        List<Integer> ans = new ArrayList<>();
        List<Integer> negIdxs = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(arr[i] < 0){
                negIdxs.add(i);
            }
        }
        int idx = 0;
        int l = 0;
        int r = k-1;
        
        while(r < n){
            
            if(idx >= negIdxs.size()){
                ans.add(0);
                l++;
                r++;
                continue;
            }
            
            
            
            if(negIdxs.get(idx) < l){
                idx++;
            }
            
            if(idx >= negIdxs.size()){
                ans.add(0);
                l++;
                r++;
                continue;
            }
            if(negIdxs.get(idx) >= l && negIdxs.get(idx) <= r){
                ans.add(arr[negIdxs.get(idx)]);
            }else{
                ans.add(0);
            }
            l++; r++;
        }
        
        return ans;
        
    }
}