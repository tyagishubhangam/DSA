class Solution {
    public String largestNumber(int[] nums) {
        List<Integer> li = new ArrayList<>();
        for(int i:nums){
            li.add(i);
        }

        Collections.sort(li, new CustomSort());
        String res = "";
        for(int i:li){
            res += Integer.toString(i);
        }
        return res.charAt(0) != '0'? res : "0";
    }
}

class CustomSort implements Comparator<Integer>{
    public int compare(Integer a, Integer b){
        String s1 = Integer.toString(a) + Integer.toString(b);
        String s2 = Integer.toString(b) + Integer.toString(a);

       

        return s2.compareTo(s1);



    }
}