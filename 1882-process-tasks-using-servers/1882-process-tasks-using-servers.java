class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        int numOfServers = servers.length;
        int numOfTasks = tasks.length;
        PriorityQueue<Integer> serversFree = new PriorityQueue<>((a,b)->servers[a] == servers[b] ? a-b : servers[a] - servers[b]);
        PriorityQueue<BusyServer> serversBusy = new PriorityQueue<>((a,b)-> Long.compare(a.freeTime, b.freeTime));

        // initially all servers are free
        for(int i=0;i<numOfServers;i++){
            serversFree.offer(i);
        }
        int result[] = new int[numOfTasks];
        long time = 0;
        for(int i=0;i<numOfTasks;i++){
            time = Math.max(time, i);
            while(!serversBusy.isEmpty() && serversBusy.peek().freeTime <= time){
                serversFree.offer(serversBusy.poll().idx);
            }
            
            if(serversFree.isEmpty()){
                BusyServer toBeFree = serversBusy.poll();
                long timeToFree = toBeFree.freeTime;
                time = timeToFree;
                serversFree.offer(toBeFree.idx);
                while(!serversBusy.isEmpty() && serversBusy.peek().freeTime <= time){
                    serversFree.offer(serversBusy.poll().idx);
                }
            }
            int idx = serversFree.poll();
            result[i] = idx;
            serversBusy.offer(new BusyServer(idx, time+tasks[i]));
        }



        return result;
    }
}

class BusyServer{
    int idx;
    long freeTime;
    BusyServer(int idx, long freeTime){
        this.idx = idx;
        this.freeTime = freeTime;
    }
}

