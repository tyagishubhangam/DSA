class Solution {
    int ans;
    public int countPalindromicSubsequence(String s) {
        HashSet<String> hs = new HashSet<>();
        ans = 0;
        recurse(0,s,"",0, hs);
        return ans;
    }

    public void recurse(int i, String s, String st, int cnt, HashSet<String> hs){
        if(cnt == 3){
            
            if(!hs.contains(st) && isPalindrome(st)){
                // System.out.println(st);
                ans++;
                hs.add(st);
            }
            return;
        }
        if(i >= s.length()){
            return ;
        }

        recurse(i+1,s, st+s.charAt(i), cnt+1, hs);
        recurse(i+1,s,st,cnt, hs);
    }

    public boolean isPalindrome(String st){
        int l = 0;
        int r = st.length() - 1;
        while(l <= r){
            if(st.charAt(l) != st.charAt(r)){
                return false;
            }
            l++;
            r--;
        }

        return true;
    }
}