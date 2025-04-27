//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            int n = a1.length;
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(a1[i]);
            }

            String line2 = br.readLine();
            String[] a2 = line2.trim().split("\\s+");
            n = a2.length;
            int b[] = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = Integer.parseInt(a2[i]);
            }

            int ans = new Solution().maxMeetings(a, b);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public int maxMeetings(int start[], int end[]) {
        // add your code here
        int n = start.length;
        if(n == 1){
            return 1;
        }
        List<Pair> li = new ArrayList<>();
        for(int i=0;i<start.length;i++){
            Pair p = new Pair(start[i], end[i]);
            li.add(p);
        }
        
        
        Collections.sort(li, new SortByEndTime());
        
        int cnt = 1;
        int prevEnd = li.get(0).endTime;
        for(int i=1;i<n;i++){
            
            int currStart = li.get(i).startTime;
            if(currStart > prevEnd){
                cnt += 1;
                prevEnd = li.get(i).endTime;
            }
        }
        return cnt;
    }
}

class Pair{
    int startTime;
    int endTime;
    Pair(int startTime, int endTime){
        this.startTime = startTime;
        this.endTime = endTime;
    }
    
}


class SortByEndTime implements Comparator<Pair>{
    public int compare(Pair p1, Pair p2){
        return p1.endTime - p2.endTime;
    }
}
