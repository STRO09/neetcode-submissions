class Twitter {

    
    Map<Integer, Set<Integer>> following;
    Map<Integer, List<Tweet>> tweets; 
    
    private static int counter = 0;

    static class Tweet {
        int time;
        int tweetId;
        int userId;

        public Tweet(int time, int tId, int uId) {
            this.time = time;
            this.tweetId = tId; 
            this.userId = uId; 
        }
    }

    public Twitter() { 
        this.following = new HashMap<>();  
        this.tweets = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.putIfAbsent(userId, new ArrayList<>());
        tweets.get(userId).add(new Tweet(counter++, tweetId, userId));        
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed = new ArrayList<>();
        PriorityQueue<Tweet> tweetq = new PriorityQueue<>((a,b)-> b.time - a.time);
        if(following.containsKey(userId) && !following.get(userId).isEmpty())
        for(int u : following.get(userId)) {
           if(tweets.containsKey(u)) {
            for(Tweet t : tweets.get(u)) {
                tweetq.add(t);
            }
           }
           
        } 
        if(tweets.containsKey(userId))
        for(Tweet t : tweets.get(userId)) {
            tweetq.add(t);
        }

        for(int i=0 ; i < 10 && !tweetq.isEmpty(); i++) { 
            feed.add(tweetq.poll().tweetId);
        }
        return feed;

    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId!=followeeId){
            following.putIfAbsent(followerId, new HashSet<>());
            following.get(followerId).add(followeeId); 
        }  
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(following.containsKey(followerId) && followerId != followeeId)
        following.get(followerId).remove(followeeId);     
    }
}
