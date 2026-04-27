import java.util.*;

public class Task3 {
    private int time;
    private Map<Integer, Set<Integer>> followMap;
    private Map<Integer, List<int[]>> tweetMap;

    public Task3() {
        time = 0;
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        tweetMap.putIfAbsent(userId, new ArrayList<>());
        tweetMap.get(userId).add(new int[]{time, tweetId});
        time++;
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        followMap.putIfAbsent(userId, new HashSet<>());
        followMap.get(userId).add(userId);

        for (int followeeId : followMap.get(userId)) {
            if (tweetMap.containsKey(followeeId)) {
                for (int[] tweet : tweetMap.get(followeeId)) {
                    maxHeap.add(tweet);
                }
            }
        }

        List<Integer> result = new ArrayList<>();

        while (!maxHeap.isEmpty() && result.size() < 10) {
            result.add(maxHeap.poll()[1]);
        }

        return result;
    }

    public void follow(int followerId, int followeeId) {
        followMap.putIfAbsent(followerId, new HashSet<>());
        followMap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId) && followerId != followeeId) {
            followMap.get(followerId).remove(followeeId);
        }
    }

    public static void main(String[] args) {
        Task3 twitter = new Task3();

        twitter.postTweet(1, 5);
        twitter.postTweet(1, 3);
        twitter.postTweet(1, 2);
        twitter.postTweet(2, 6);

        twitter.follow(1, 2);

        System.out.println(twitter.getNewsFeed(1));

        twitter.unfollow(1, 2);

        System.out.println(twitter.getNewsFeed(1));
    }
}