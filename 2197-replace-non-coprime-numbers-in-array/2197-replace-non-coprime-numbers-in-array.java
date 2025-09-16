class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        if(n == 1){
            ans.add(nums[0]);
            return ans;
        }
        Stack<Integer> st = new Stack<>();
        // st.push(nums[0]);
        for(int i=0;i<n;i++){
            st.push(nums[i]);
            while(st.size() >=2){
                int b = st.pop();
                int a = st.pop();
                int gcd = GCD(a,b);
                // System.out.println(gcd);
                if(gcd != 1){
                    // st.pop();
                    long lcm = (long)a*b / gcd;
                    st.push((int)lcm);
                }else{
                    st.push(a);
                    st.push(b);
                    break;
                }
            }
            
        }
        while(!st.isEmpty()){
            ans.add(st.pop());
        }
        

        Collections.reverse(ans);
        return ans;
    }

    public int GCD(int a, int b){
        int divisor = Math.min(a,b);
        int dividend = Math.max(a,b);
        while(dividend % divisor != 0){
            int tmp = divisor;
            divisor = dividend % divisor;
            dividend = tmp;
        }

        return divisor;
    }
}