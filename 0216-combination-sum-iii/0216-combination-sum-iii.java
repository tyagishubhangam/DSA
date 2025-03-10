class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> li = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        getCombinations(1,k,n,tmp,li);
        return li;
    }

    public static void getCombinations(int idx, int k, int n, List<Integer> tmp, List<List<Integer>> li){
        if(tmp.size() == k ){
            if(n == 0){
                li.add(new ArrayList<>(tmp));
            }
            
            return;
        }
        if(idx > 9 || n<0){
            return;
        }

        tmp.add(idx);
        
        getCombinations(idx + 1, k,n - idx, tmp, li);
        tmp.removeLast();
        getCombinations(idx+1,k,n,tmp,li);


    }
}