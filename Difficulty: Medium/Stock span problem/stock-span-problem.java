
class Solution {
    public ArrayList<Integer> calculateSpan(int[] arr) {
        // code here
        int n = arr.length;
        ArrayList<Integer> res = new ArrayList<>();
        Stack<int[]> st = new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && st.peek()[0] <= arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                res.add(i+1);
            }else{
                res.add(i - st.peek()[1]);
            }
            st.push(new int[]{arr[i], i});
            
        }
        return res;
    }
}