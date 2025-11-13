class Solution {
    public static void reverseStack(Stack<Integer> st) {
        // code here
        recurse(st);
        
    }
    
    public static void recurse(Stack<Integer> st){
        if(st.isEmpty()){
            return;
        }
        int x = st.pop();
        recurse(st);
        Stack<Integer> tmp = new Stack<>();
        while(!st.isEmpty()){
            tmp.push(st.pop());
        }
        
        st.push(x);
        while(!tmp.isEmpty()){
            st.push(tmp.pop());
        }
        
    }
}
