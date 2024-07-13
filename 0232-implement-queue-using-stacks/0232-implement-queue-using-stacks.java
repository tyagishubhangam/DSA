class MyQueue {
    Stack <Integer> s1;
    Stack<Integer> s2;

    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    public void push(int x) {
        try{
        while(s1.peek()!=null){
            s2.push(s1.pop());
        }}catch(Exception e){

        }
        s1.push(x);
        try{
        while(s2.peek()!=null){
            s1.push(s2.pop());
        }} catch(Exception e){

        }
    }
    
    public int pop() {
        return s1.pop();
    }
    
    public int peek() {
        return s1.peek();
    }
    
    public boolean empty() {
        return s1.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */