class Solution {
    public int minFlips(String s) {
        int n = s.length();
        int startWithZero = 0;
        int startWithOne = 0;
        String tmp = s + s;

        for(int i=0;i<n;i++){
            char ch = tmp.charAt(i);
            if(i%2 == 0){
                if(ch != '0'){
                    startWithZero++;
                }else{
                    startWithOne++;
                }
            }else{
                if(ch != '1'){
                    startWithZero++;
                }else{
                    startWithOne++;
                }
            }
        }
        int res = Math.min(startWithOne, startWithZero);
        int ans = res;
        int l = 0;
        int r = n;
        while(r < (n+n)){
            char rem = tmp.charAt(l);
            char add = tmp.charAt(r);
            if(l % 2 == 0){
                if(rem != '0'){
                    startWithZero--;
                }else{
                    startWithOne--;
                }
            }else{
                if(rem != '1'){
                    startWithZero--;
                }else{
                    startWithOne--;
                }
            }

            if(r % 2 == 0){
                if(rem != '0'){
                    startWithZero++;
                }else{
                    startWithOne++;
                }
            }else{
                if(rem != '1'){
                    startWithZero++;
                }else{
                    startWithOne++;
                }
            }

            res = Math.min(startWithOne, startWithZero);
            ans = Math.min(res, ans);
            l++;
            r++;
        }
        return ans;
    }
}