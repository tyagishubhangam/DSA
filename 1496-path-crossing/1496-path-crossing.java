class Solution {
    public boolean isPathCrossing(String path) {
        HashSet<List<Integer>> hs = new HashSet<>();
        int i = 0;
        int j = 0;
        List<Integer> src = new ArrayList<>();
    src.add(0);
    src.add(0);
        hs.add(src);
        for(int k=0;k<path.length();k++){
            char ch = path.charAt(k);
            if(ch == 'N'){
                i--;
            }else{
                if(ch == 'S'){
                    i++;
                }else{
                    if(ch == 'E'){
                        j++;
                    }else{
                        j--;
                    }
                }
            }
            List<Integer> tmp = new ArrayList<>();
            tmp.add(i);
            tmp.add(j);
            if(hs.contains(tmp)){
                return true;
            }
            hs.add(tmp);
        }
        return false;
        
    }
}