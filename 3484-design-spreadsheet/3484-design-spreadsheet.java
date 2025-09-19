class Spreadsheet {
    HashMap<Character, int[]> hs;
    
    public Spreadsheet(int rows) {
        hs = new HashMap<>();
       
        for(char c='A'; c <='Z';c++){
            hs.put(c, new int[rows+1]);
           
        }

        
    }
    
    public void setCell(String cell, int value) {
        char c = cell.charAt(0);
        int row = Integer.parseInt(cell.substring(1));
        // int currSum = colSum.get(c);
        // currSum -= hs.get(c)[row];
        // currSum += value;
        // colSum.put(c,currSum);
        hs.get(c)[row] = value;
    }
    
    public void resetCell(String cell) {
        char c = cell.charAt(0);
        int row = Integer.parseInt(cell.substring(1));
        // int currSum = colSum.get(c);
        // currSum -= hs.get(c)[row];
        // colSum.put(c,currSum);
        hs.get(c)[row] = 0;
    }
    
    public int getValue(String formula) {
        String[] st = formula.split("\\+");
        System.out.println(formula);
        
        int val = 0;
        char col1 = st[0].charAt(1);
        if(Character.isLetter(col1)){
            int row = Integer.parseInt(st[0].substring(2));
            val += hs.get(col1)[row];
        }else{
            val += Integer.parseInt(st[0].substring(1));
        }

        char col2 = st[1].charAt(0);
        if(Character.isLetter(col2)){
            int row = Integer.parseInt(st[1].substring(1));
            val += hs.get(col2)[row];
        }else{
            val += Integer.parseInt(st[1]);
        }
        

        return val;
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */