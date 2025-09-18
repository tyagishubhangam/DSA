class TaskManager {
    HashMap<Integer, Task> tasksMap;
    TreeSet<Task> st;
    public TaskManager(List<List<Integer>> tasks) {
        tasksMap = new HashMap<>();
        st = new TreeSet<>(new SortTheSet());
        for(List<Integer> li : tasks){
            Task task = new Task(li.get(0), li.get(1), li.get(2));
            st.add(task);
            tasksMap.put(li.get(1),task);
        }
    }
    
    public void add(int userId, int taskId, int priority) {
        Task tmp = new Task(userId, taskId, priority);
        
        st.add(tmp);
        tasksMap.put(taskId, tmp);  
    }
    
    public void edit(int taskId, int newPriority) {
        Task toEdit = tasksMap.get(taskId);
        st.remove(toEdit);
        toEdit.priority = newPriority;
        st.add(toEdit);

    }
    
    public void rmv(int taskId) {
        Task toRemove = tasksMap.get(taskId);
        st.remove(toRemove);
    }
    
    public int execTop() {
        if(st.isEmpty()){
            return -1;
        }
        Task top = st.first();
        st.remove(top);
        tasksMap.remove(top.taskId);
        return top.userId;
    }
}

class SortTheSet implements Comparator<Task>{
    public int compare(Task a, Task b){
        if(a.priority == b.priority){
            return b.taskId - a.taskId;
        }
        return b.priority - a.priority;
    }
}
class Task{
    int userId;
    int taskId;
    int priority;
    Task(int userId, int taskId, int priority){
        this.userId = userId;
        this.taskId = taskId;
        this.priority = priority;
    }
}
/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */