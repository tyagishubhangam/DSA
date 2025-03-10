class Solution {
    public static List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();
        
        for(int i=1;i<=9;i++){
            int num = i;
            while(num <= high){
                int lastDigit = num%10;
                if(lastDigit <9){
                num = num*10 + lastDigit+1;
                if(num >= low && num<= high){
                    ans.add(num);
                }}else{
                    break;
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }

}