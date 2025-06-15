class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }
        HashMap<Character, Integer> hs = new HashMap<>();
        for(int i=0;i<s1.length();i++){
            char ch = s1.charAt(i);
            hs.put(ch,hs.getOrDefault(ch,0) + 1);
        }
        int l = 0;
        int r = 0;
        HashMap<Character, Integer> s1map = new HashMap<>(hs);
        while(r<s2.length()){
            char ch2 = s2.charAt(r);
            if(s1map.get(ch2) == null){
                l++;
                r = l;
                s1map = new HashMap<>(hs);
                continue;
            }
            s1map.put(ch2, s1map.get(ch2) - 1);
            if(s1map.get(ch2) == 0){
                s1map.remove(ch2);
            }
            if(s1map.size() == 0){
                return true;
            }
            r++;
        }
        return false;
    }
}