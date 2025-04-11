import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	public static void main (String[] args)
	 {
	 //code
	 Scanner sc = new Scanner(System.in);
	 int t = sc.nextInt();
	 while(t-->0){
	     int n = sc.nextInt();
	     HashMap<Integer,Integer> hs = new HashMap<>();
	     int[] arr = new int[n];
	     for(int i=0;i<n;i++){
	         arr[i] = sc.nextInt();
	         hs.put(arr[i], hs.getOrDefault(arr[i],0) + 1);
	     }
	     List<Pair> li = new ArrayList<>();
	     for(int i=0;i<n;i++){
	         Pair p = new Pair(arr[i], hs.get(arr[i]));
	         li.add(p);
	     }
	     Collections.sort(li, new SortByFreq());
	     for(Pair p:li){
	         System.out.print(p.data +" ");
	     }
	     System.out.println("");
	     
	 }
	 }
}

class Pair{
    int data;
    int freq;
    Pair(int data, int freq){
        this.data = data;
        this.freq = freq;
    }
}

class SortByFreq implements Comparator<Pair>{
   public int compare(Pair p1, Pair p2){
       if(p1.freq == p2.freq){
          return p1.data - p2.data;
       }
       return p2.freq - p1.freq;
   }
}