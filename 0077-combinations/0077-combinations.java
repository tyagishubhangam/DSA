class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> li = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        getCombinations(1,n,k,tmp,li);
        return li;
    }

    public static void getCombinations(int idx,int n, int k, List<Integer> tmp, List<List<Integer>> li){
        if(tmp.size() == k){
            li.add(new ArrayList<>(tmp));
            return;
        }
        if(idx > n){
            return;
        }

        tmp.add(idx);
        getCombinations(idx+1,n,k,tmp,li);
        tmp.removeLast();
        getCombinations(idx+1,n,k,tmp,li);
            
    }
}