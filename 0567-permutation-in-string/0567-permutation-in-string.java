class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }
        HashMap<Character, Integer> hs = new HashMap<>();
        for(int i=0;i<s1.length();i++){
            char ch = s1.charAt(i);
            hs.put(ch, hs.getOrDefault(ch, 0)+1);
        }
        int l = 0;
        int r = 0;
        while(r < s1.length()){
            char tmp = s2.charAt(r);
            if(hs.containsKey(tmp)){
                hs.put(tmp,hs.get(tmp) - 1);
            }
            r++;
        }

        if(isPermutationPresent(hs, s1)){
            return true;
        }

        while(r< s2.length()){
            char end = s2.charAt(r);
            if(hs.containsKey(end)){
                hs.put(end,hs.get(end) - 1);
            }
            char start = s2.charAt(l);
            if(hs.containsKey(start)){
                hs.put(start,hs.get(start) + 1);
            }

            if(isPermutationPresent(hs, s1)){
                return true;
            }
            l++;
            r++;
        }
        
        return false;
    }

    public static boolean isPermutationPresent(HashMap<Character, Integer> hs, String s1){
        for(int i=0;i<s1.length();i++){
            if(hs.get(s1.charAt(i)) > 0){
                return false;
            }
        }
        return true;
    }
}