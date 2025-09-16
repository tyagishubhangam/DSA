class Solution {
    public String findCommonResponse(List<List<String>> responses) {
        int n = responses.size();
        HashMap<String, Integer> hm = new HashMap<>();
        for(int i=0;i<n;i++){
            HashSet<String> hs = new HashSet<>();
            for(String tmp : responses.get(i)){
                if(!hs.contains(tmp)){
                    hs.add(tmp);
                    hm.put(tmp,hm.getOrDefault(tmp, 0)+1);
                }
            }
        }
        String maxString = "";
        int maxFreq = 0;
        for(String tmp : hm.keySet()){
            if(maxFreq < hm.get(tmp)){
                maxFreq = hm.get(tmp);
                maxString = tmp;
            }else{
                if(maxFreq == hm.get(tmp)){
                    if(maxString.compareTo(tmp) > 0){
                        maxString = tmp;
                    }
                }
            }
        }
        return maxString;
    }
}