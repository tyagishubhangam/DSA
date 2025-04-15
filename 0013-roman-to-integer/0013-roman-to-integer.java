class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> hs = new HashMap<>();
        hs.put('I',1);
        hs.put('V',5);
        hs.put('X',10);
        hs.put('L',50);
        hs.put('C',100);
        hs.put('D',500);
        hs.put('M',1000);
        int ans = 0;
        for(int i=s.length() - 1;i>=0;i--){
            int ch = hs.get(s.charAt(i));
            if(i == 0){
                ans += ch;
            }else{
                ans += ch;
                int chx = hs.get(s.charAt(i - 1));
                if(chx < ch){
                    ans -= chx;
                    i--;
                }
            }
            
        }
        return ans;
    }
}