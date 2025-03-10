class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> tmp = new ArrayList<>();
        List<List<Integer>> li = new ArrayList<>();
        generateCombos(0,target,tmp,li,candidates);
        return li;
    }

    public static void generateCombos(int idx, int sum,List<Integer> tmp,List<List<Integer>> li, int[] candidates){
        if(sum == 0){
            li.add(new ArrayList<>(tmp));
            return;
        }
        if(sum < 0){
            return;
        }
        if(idx == candidates.length){
            return ;
        }
        tmp.add(candidates[idx]);
        generateCombos(idx,sum - candidates[idx], tmp,li,candidates);
        tmp.removeLast();
        generateCombos(idx+1,sum , tmp,li,candidates);
    }
}