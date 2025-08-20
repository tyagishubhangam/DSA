class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(numCourses == 1){
            return new int[]{0};
        }
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        

        for(int[] prereq : prerequisites){
            int u = prereq[1];
            int v = prereq[0];
            adj.get(u).add(v);
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] visitedRecur = new boolean[numCourses];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<numCourses;i++){
            if(!visited[i] && checkCycle(adj, i, visited, visitedRecur, st)){
                return new int[0];
            }
        }
        int[] result = new int[numCourses];
        int i = 0;
        while(!st.isEmpty()){
            result[i] = st.pop();
            i++;
        }

        return result;


    }
    public static boolean checkCycle(List<List<Integer>> adj, int u, boolean[] visited, boolean[] visitedRecur, Stack<Integer>st){
        if(visited[u] && visitedRecur[u]){
            return true;
        }
        visited[u] = true;
        visitedRecur[u] = true;
        for(int v : adj.get(u)){
            if(!visited[v] && checkCycle(adj, v, visited, visitedRecur, st)){
                return true;
            }
            if(visitedRecur[v]){
                return true;
            }
        }
        st.push(u);

        visitedRecur[u] = false;

        return false;
    }
}