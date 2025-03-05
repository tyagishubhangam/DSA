class Solution {
    public List<String> letterCombinations(String digits) {
        List<String>ans = new ArrayList<>();

        if(digits.length() == 0){
            return ans;
        }
        List<List<Character>> combinations = new ArrayList<>();
        combinations.add(List.of('a','b','c'));
        combinations.add(List.of('d','e','f'));
        combinations.add(List.of('g','h','i'));
        combinations.add(List.of('j','k','l'));
        combinations.add(List.of('m','n','o'));
        combinations.add(List.of('p','q','r','s'));
        combinations.add(List.of('t','u','v'));
        combinations.add(List.of('w','x','y','z'));

        generateAllOutcomes("", 0, combinations, digits, ans);

        return ans;


        
    }

    public static void generateAllOutcomes(String tmp, int idx, List<List<Character>> combinations, String digits,List<String> ans){
        if(idx == digits.length()){
            ans.add(tmp);
            return;
        }

        for(int i=0;i<combinations.get(digits.charAt(idx) - '2').size();i++){
            generateAllOutcomes(tmp + combinations.get(digits.charAt(idx) - '2').get(i), idx+1, combinations, digits, ans );
        }
    }

    
}