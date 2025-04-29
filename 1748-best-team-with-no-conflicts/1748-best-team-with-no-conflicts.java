class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        int[] dp = new int[n];
        List<Player> li = new ArrayList<>();
        for(int i=0;i<n;i++){
            
            Player p = new Player(scores[i], ages[i]);
            li.add(p);
        }
        Collections.sort(li, new SortByAge());
        // int maxAns = 0;
        for(int i=0;i<n;i++){
            dp[i] = li.get(i).score;
            for(int j=0;j<i;j++){
                if(li.get(j).score <= li.get(i).score){
                    dp[i] = Math.max(dp[i], li.get(i).score + dp[j]);
                }
            }
        }
        return dp[n-1];
    }
}
    

class Player{
    int score;
    int age;
    Player(int score, int age){
        this.score = score;
        this.age = age;
    }
}

class SortByAge implements Comparator<Player> {
    public int compare(Player p1, Player p2){
        if(p1.age == p2.age){
            return p1.score - p2.score;
        }
        return p1.age - p2.age;
    }
}