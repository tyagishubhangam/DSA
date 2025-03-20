class Solution {
    public String getPermutation(int n, int k) {
        int factorial = 1;
        List<Integer> li = new ArrayList<>();
        for(int i=1;i<n;i++){
            factorial *= i;  //generating factorial till n-1
            li.add(i);
        }
        li.add(n);
        k = k - 1;
        String str = "";
        while(true){
            str += li.get(k/factorial);
            li.remove(k/factorial);
            if(li.size() == 0){
                break;
            }
            k = k % factorial;
            factorial = factorial / li.size();  // decrementing the factorial for next permutations

        }
        return str;
    }
}