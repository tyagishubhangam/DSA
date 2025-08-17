class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        int[] result = new int[n];
        result[n-1] = 0;
        Stack<Integer> st = new Stack<>();
        for(int i=n-1;i>=0;i--){
            int tmp = heights[i];
            int cnt = 0;
            while(!st.isEmpty() && tmp > heights[st.peek()]){
                cnt++;
                st.pop();
            }
            if(st.isEmpty()){
                if(i == n-1){
                    result[i] = 0;
                }else{
                    result[i] = cnt ;
                }
            }else{
                result[i] = cnt + 1;
            }
            st.push(i);
        }

        // result[n-1] = 0;

        return result;
    }
}