class MyStack {
    int arr[];
    int top;

    public MyStack() {
        arr = new int[100];
        top = -1;
    }
    
    public void push(int x) {
        top++;
        arr[top] = x;
        
    }
    
    public int pop() {
        int x = arr[top];
        top--;
        return x;
        
    }
    
    public int top() {
        return arr[top];
    }
    
    public boolean empty() {
        if(top == -1){
            return true;
        }
        return false;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */