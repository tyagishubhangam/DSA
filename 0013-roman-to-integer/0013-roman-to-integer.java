class Solution {
    public int romanToInt(String s) {
        Map<Character,Integer> mp = new HashMap<>();
        mp.put('I',1);
        mp.put('V',5);
        mp.put('X',10);
        mp.put('L',50);
        mp.put('C',100);
        mp.put('D',500);
        mp.put('M',1000);
        int res = 0;
        for(int i=s.length()-1;i>=0;i--){
            char ch = s.charAt(i);
            
            if(i == 0){
                res = res + mp.get(ch);
            }else{
            char chp = s.charAt(i-1);
            if(mp.get(ch) > mp.get(chp)){
                res = res + (mp.get(ch) - mp.get(chp));
                i--;
            }else{
                res = res + mp.get(ch);
            }
        }}
        return res;
    }
}