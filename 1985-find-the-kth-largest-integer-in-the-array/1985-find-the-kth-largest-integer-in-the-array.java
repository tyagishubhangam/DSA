class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        int n = nums.length;
        PriorityQueue<String> pq = new PriorityQueue<>((new SortThePQ()));

        for(String s : nums){
            pq.offer(s);
            if(pq.size() > k){
                pq.poll();
            }
        }

        return pq.poll();
        
    }
}

class SortThePQ implements Comparator<String>{
    public int compare(String a, String b){
        if(a.length() != b.length()){
            return a.length() - b.length();
        }

        int idx = 0;
        while(idx < a.length() && a.charAt(idx) == b.charAt(idx)){
            idx++;
        }
        if(idx == a.length()){
            return 0;
        }

        return a.charAt(idx) - b.charAt(idx);
    }
}