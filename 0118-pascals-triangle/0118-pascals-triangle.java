class Solution {
    public static List<Integer> generateRow(int row){
        int ans = 1;
        List<Integer> li = new ArrayList<>();
        li.add(1);
        for(int i=1;i<row;i++){
            ans = ans*(row-i);
            ans = ans/i;
            li.add(ans);

        }
        return li;
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i=1;i<=numRows;i++){
            res.add(generateRow(i));
        }
        return res;
    }
}