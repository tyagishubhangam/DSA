class Solution {
    public int getLucky(String s, int k) {
        int len = s.length();
        String str = "";
        for(int i=0;i<len;i++){
            int ch = s.charAt(i)-('a'-1);
            // System.out.println(ch);
            str = str+Integer.toString(ch);
            // System.out.println(str);
        }
        int ans=0;
        for(int j=1;j<=k;j++){
            ans = getResult(str);
            // System.out.println(ans);
            str = Integer.toString(ans);
        }
        return ans;
        
    }

    public int getResult(String num){
        int res = 0;
        System.out.println(num);
        for(int i=0;i<num.length();i++){
            int s = Character.getNumericValue(num.charAt(i));
            System.out.println(s);
            res = res+s;
            // System.out.println(res);
        }
        return res;
    }
}