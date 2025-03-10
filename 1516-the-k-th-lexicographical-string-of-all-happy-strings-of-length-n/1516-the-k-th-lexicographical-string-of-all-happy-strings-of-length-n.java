class Solution {
    public String getHappyString(int n, int k) {
        List<String> li = new ArrayList<>();
        char[] arr = new char[n];
        generateHappyStrings('a',arr,0,n,li);
        generateHappyStrings('b',arr,0,n,li);
        generateHappyStrings('c',arr,0,n,li);
        // System.out.println(li);
        if(k>li.size()){
            return "";
        }
        return li.get(k-1);
    }

    public void generateHappyStrings(char ch, char[] arr, int idx, int n,List<String> li){
        arr[idx] = ch;
        if(idx+1 == n){
            String str = "";
            for(char i : arr){
                str += i;
            }
            li.add(str);
            return;
        }
        

        
        if(ch == 'a'){
            
            generateHappyStrings('b',arr,idx + 1, n, li);
            
            generateHappyStrings('c',arr,idx + 1, n, li);

        }else{
            if(ch == 'b'){
            
                generateHappyStrings('a',arr,idx + 1, n, li);
            
                generateHappyStrings('c',arr,idx + 1, n, li);

            }else{
                generateHappyStrings('a',arr,idx + 1, n, li);
            
                generateHappyStrings('b',arr,idx + 1, n, li);
            }
        }
    }
}