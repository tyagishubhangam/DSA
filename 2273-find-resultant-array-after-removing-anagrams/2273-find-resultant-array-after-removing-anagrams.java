class Solution {
    public List<String> removeAnagrams(String[] words) {
        int n = words.length;
        List<String> res = new ArrayList<>();
        res.add(words[0]);
        for(int i = 1;i<n;i++){
            char[] tmp = words[i].toCharArray();
            Arrays.sort(tmp);
            char[] tmp2 = res.get(res.size()-1).toCharArray();
            Arrays.sort(tmp2);
            String t1 = new String(tmp);
            String t2 = new String(tmp2);
            if(!t1.equals(t2)){
                res.add(words[i]);
            }

        }
        return res;
    }
}