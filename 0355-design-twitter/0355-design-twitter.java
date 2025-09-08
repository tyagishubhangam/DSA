class Twitter {
    HashMap<Integer,Set<Integer>> user;
    HashMap<Integer, List<long[]>> tweets;
    public Twitter() {
        user = new HashMap<>();
        tweets = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        
        if(tweets.get(userId) == null){
            tweets.put(userId, new ArrayList<>());
        }
        tweets.get(userId).add(new long[]{System.currentTimeMillis(), tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b)-> Long.compare(a[0], b[0]));
        List<Integer> feed = new ArrayList<>();
        if(tweets.get(userId) != null){

        for(long[] id : tweets.get(userId)){
            pq.offer(id);
            if(pq.size() > 10){
                pq.poll();
            }
        }
        }
        // System.out.println(user.get(userId));
        if(user.get(userId) != null){
            
        for(int following : user.get(userId)){
            if(tweets.get(following) != null){

            for(long[] id : tweets.get(following)){
                pq.offer(id);
                if(pq.size() > 10){
                    pq.poll();
                }
            }
            }
        }
        }
        
        while(!pq.isEmpty()){
            feed.add(0, (int)pq.poll()[1]);
        }

        return feed;
        
    }
    
    public void follow(int followerId, int followeeId) {
        if(user.get(followerId) == null){
            user.put(followerId, new HashSet<>());
        }
        user.get(followerId).add(followeeId);
        // System.out.println(followeeId +"--"+user.get(followeeId));
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(user.get(followerId) == null){
            return ;
        }
        user.get(followerId).remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */