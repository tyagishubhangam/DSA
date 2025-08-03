class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        // code here
        int n = arr.length;
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[i] >= st.peek()){
                st.pop();
            }
            if(st.isEmpty()){
                res.add(-1);
            }else{
                res.add(st.peek());
            }
            st.push(arr[i]);
        }
        Collections.reverse(res);
        return res;
        
    }
}