class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        if(n == 1){
            ans.add(nums[0]);
            return ans;
        }
        Stack<Integer> st = new Stack<>();
        st.push(nums[0]);
        for(int i=1;i<n;i++){
            int b = nums[i];
            while(!st.isEmpty()){
                int a = st.peek();
                int gcd = GCD(a,b);
                if(gcd == 1){
                    break;
                }
                st.pop();
                long lcm = (long)a * b / gcd;
                b = (int)lcm;
            }
            
            
            st.push(b);
            
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