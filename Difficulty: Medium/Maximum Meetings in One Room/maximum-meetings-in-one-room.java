//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N; 
            N = Integer.parseInt(br.readLine());
            
            
            int[] S = IntArray.input(br, N);
            
            
            int[] F = IntArray.input(br, N);
            
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.maxMeetings(N, S, F);
            
            IntArray.print(res);
            
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


class Solution {
    public static ArrayList<Integer> maxMeetings(int N, int[] S, int[] F) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        int n = S.length;
        if(n == 1){
            ans.add(1);
            return ans;
        }
        
        List<Pair> li = new ArrayList<>();
        for(int i=0;i<n;i++){
            Pair p = new Pair(S[i], F[i],i);
            li.add(p);
        }
        Collections.sort(li, new SortByEnd());
        
        ans.add(li.get(0).idx+ 1);
        int prev = li.get(0).end;
        for(int i=1;i<n;i++){
            if(prev < li.get(i).start){
                ans.add(li.get(i).idx + 1);
                prev = li.get(i).end;
            }
        }
         Collections.sort(ans);
        return ans;
        
    }
}

class SortByEnd implements Comparator<Pair>{
    public int compare(Pair p1, Pair p2){
        if(p1.end == p2.end){
            return p1.idx - p2.idx;
        }
        return p1.end - p2.end;
    }
}

class Pair{
    int start;
    int end;
    int idx;
    Pair(int start, int end, int idx){
        this.start = start;
        this.end = end;
        this.idx = idx;
    }
}
