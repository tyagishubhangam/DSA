// User function Template for Java

class Solution {

    int search(String pat, String txt) {
        // code here
        HashMap<Character, Integer> hs = new HashMap<>();
        int n = pat.length();
        int ans = 0;
        for(int i=0;i<n;i++){
            char ch = pat.charAt(i);
            hs.put(ch, hs.getOrDefault(ch, 0) + 1);
        }
        int cnt = hs.size();

        for(int i=0;i<n;i++){
            char ch = txt.charAt(i);
            if(hs.get(ch) != null){
                hs.put(ch, hs.get(ch) - 1);
            if(hs.get(ch) == 0){
                cnt--;
            }
            }
            
            
        }
        if(cnt == 0){
            ans += 1;
        }

        
        int i = 0;
        int j = n;
        while(j<txt.length()){
           char start = txt.charAt(i);
           char end = txt.charAt(j);
           if(hs.get(start) != null){
               
               hs.put(start, hs.get(start) + 1);
               if(hs.get(start) == 1){
                   cnt++;
               }
           }
           if(hs.get(end) != null){
               hs.put(end , hs.get(end) - 1);
           if(hs.get(end) == 0){
               cnt--;
           }
           }

           
           if(cnt == 0){
               ans += 1;
           }
           i++;
           j++;
        }
        
        return ans;
    }
}