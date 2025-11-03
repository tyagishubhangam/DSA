class MyHashSet {
    List<Integer> li;
    public MyHashSet() {
        li = new ArrayList<>();
    }
    
    public void add(int key) {
        if(li.indexOf(key) == -1){
            li.add(key);
        }
    }
    
    public void remove(int key) {
        if(li.indexOf(key) != -1){
            li.remove(li.indexOf(key));
        }
        
    }
    
    public boolean contains(int key) {
        return li.indexOf(key) != -1;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */