class BrowserHistory {
    ListNode head;
    public BrowserHistory(String homepage) {
        head = new ListNode(homepage);
    }
    
    public void visit(String url) {
        ListNode vis = new ListNode(url);
        vis.prev = head;
        head.next = vis;
        head = head.next;

    }
    
    public String back(int steps) {
        while(steps > 0 && head.prev != null){
            head = head.prev;
            steps--;
        }

        return head.val;
    }
    
    public String forward(int steps) {
        while(steps > 0 && head.next != null){
            head = head.next;
            steps--;
        }
        return head.val;
    }
}
class ListNode {
    String val;
    ListNode prev;
    ListNode next;
    ListNode(String val){
        this.val = val;
        
    }
    ListNode(String val, ListNode prev, ListNode next){
        this.val = val;
        this.next = next;
        this.prev = prev;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */