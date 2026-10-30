class Solution {
    public int calculateScore(int a, int b) {
        int s1 = countSetBits(a);
        int s2 = countSetBits(b);

        if(s1 >= s2){
            return s1*s2;
        }

        return s2/s1;
    }

    public int countSetBits(int n){
        String s = Integer.toBinaryString(n);
        int cnt = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '1'){
                cnt++;
            }
        }
        return cnt;
    }
}