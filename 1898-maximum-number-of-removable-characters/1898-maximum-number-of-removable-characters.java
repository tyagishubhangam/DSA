class Solution {
    public int maximumRemovals(String s, String p, int[] removable) {
        int n = s.length();
        int l = 0;
        int r = removable.length;
        int ans = 0;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(isValid(s,p,removable, mid)){
                ans = Math.max(ans, mid);
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }

        return ans;
    }

    public boolean isValid(String s, String p, int[] removable, int mid){
        StringBuilder st = new StringBuilder(s);
        for(int i=0;i<mid;i++){
            st.setCharAt(removable[i],'-');
        }
        int n = st.length();
        int m = p.length();
        int i = 0;
        int j = 0;
        while(i<n && j < m){
            char ch1 = st.charAt(i);
            char ch2 = p.charAt(j);
            if(ch1 != ch2){
                i++;
            }else{
                i++;
                j++;
            }
        }
        if(j >= m){
            return true;
        }

        return false;
    }
}