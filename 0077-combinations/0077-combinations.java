class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> li = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        recurse(1,k,li, tmp, n);
        return li;
    }

    public void recurse(int i, int k, List<List<Integer>> li, List<Integer> tmp, int n){
        if(tmp.size() == k){
            li.add(new ArrayList<>(tmp));
            return;
        }
        if(tmp.size() > k || i > n){
            return ;
        }
        tmp.add(i);
        int idx = tmp.size()-1;
        recurse(i+1, k,li,tmp,n);
        tmp.remove(idx);
        recurse(i+1, k, li, tmp, n);
        
    }
}