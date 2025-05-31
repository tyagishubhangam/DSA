class Solution {
    static ArrayList<Integer> maxOfSubarrays(int[] arr, int k) {
        // code here
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<Integer> tmp = new ArrayList<>();
        tmp.add(-1);
        for(int i=0;i<k;i++){
            if(arr[i] > tmp.get(0)){
                tmp.clear();
                
            }
            while(tmp.size() > 0 && tmp.get(tmp.size()-1) < arr[i]){
                tmp.remove(tmp.size() - 1);
            }
            tmp.add(arr[i]);
        }
        ans.add(tmp.get(0));
        
        int i = 0;
        int j = k;
        while(j<n){
            
            int remove = arr[i];
            int toInsert = arr[j];
            if(remove == tmp.get(0)){
                tmp.remove(0);
            }
            // if(toInsert > tmp.get(0)){
            //     tmp.clear();
                
            // }
            while(tmp.size() > 0 && tmp.get(tmp.size() - 1) < toInsert){
                tmp.remove(tmp.size() - 1);
            }
            tmp.add(toInsert);
            ans.add(tmp.get(0));     
            i++;
            j++;
            
        }
        return ans;
    }
}