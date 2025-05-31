class Solution {
    static List<Integer> firstNegInt(int arr[], int k) {
        // write code here
        int n = arr.length;
        List<Integer> tmp = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<k;i++){
            int x = arr[i];
            if(x < 0){
                tmp.add(x);
            }
        }
        
        if(tmp.size() == 0){
            ans.add(0);
        }else{
            ans.add(tmp.get(0));
        }
        int i = 0;
        int j = k;
        while(j<n){
            if(arr[j] < 0){
                tmp.add(arr[j]);
            }
            if(tmp.size() != 0 && arr[i] == tmp.get(0)){
                tmp.remove(0);
            }
            if(tmp.size() == 0){
                ans.add(0);
            }else{
                ans.add(tmp.get(0));
            }
            j++;
            i++;
        }
        
        // System.out.println(ans);
        return ans;
    }
}