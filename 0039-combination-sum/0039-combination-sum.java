class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> li = new ArrayList<>();
        List<Integer> tmp= new ArrayList<>();
        recurse(0,candidates, target, li, tmp);
        return li;
        
    }

    public void recurse(int i, int[] candidates, int target, List<List<Integer>> li, List<Integer> tmp){
        if(target == 0){
            li.add(new ArrayList<>(tmp));
            return;
        }
        if(i >=candidates.length){
            return;
        }
        if(target < 0){
            return;
        }

        tmp.add(candidates[i]);
        int idx = tmp.size() - 1;
        recurse(i, candidates, target-candidates[i],li, tmp);
        tmp.remove(idx);
        recurse(i+1, candidates, target, li, tmp);
    }
}