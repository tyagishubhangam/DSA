class MyLinkedList {
    List<Integer> li;
    public MyLinkedList() {
        li = new ArrayList<>();
    }
    
    public int get(int i) {
        if(i >= li.size()){
            return -1;
        }

        return li.get(i);
    }
    
    public void addAtHead(int val) {
        li.add(0, val);
    }
    
    public void addAtTail(int val) {
        li.add(val);
    }
    
    public void addAtIndex(int index, int val) {
        if(index > li.size()){
            return;
        }
        li.add(index, val);
    }
    
    public void deleteAtIndex(int index) {
        if(li.size() > 0){
            if(index <= li.size()-1){
                li.remove(index);
            }
        }
        
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */