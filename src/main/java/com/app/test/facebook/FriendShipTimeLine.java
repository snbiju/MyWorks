package com.app.test.facebook;

import java.util.*;

/*

There are two lists of dictionaries representing friendship beginnings and endings:
friends_added and friends_removed. Each dictionary contains the user_ids and created_at time of the friendship
beginning /ending.

Write a function friendship_timeline to generate an output that lists the pairs of friends with their corresponding
timestamps of the friendship beginning and then the timestamp of the friendship ending.

Note: There can be multiple instances over time when two people became friends and unfriended;
only output lists when a corresponding friendship was removed.

Example:

Input:

friends_added = [
    {'user_ids': [1, 2], 'created_at': '2020-01-01'},
    {'user_ids': [3, 2], 'created_at': '2020-01-02'},
    {'user_ids': [2, 1], 'created_at': '2020-02-02'},
    {'user_ids': [4, 1], 'created_at': '2020-02-02'}]

friends_removed = [
    {'user_ids': [2, 1], 'created_at': '2020-01-03'},
    {'user_ids': [2, 3], 'created_at': '2020-01-05'},
    {'user_ids': [1, 2], 'created_at': '2020-02-05'}]
Output:

friendships = [{
    'user_ids': [1, 2],
    'start_date': '2020-01-01',
    'end_date': '2020-01-03'
  },
  {
    'user_ids': [1, 2],
    'start_date': '2020-02-02',
    'end_date': '2020-02-05'
  },
  {
    'user_ids': [2, 3],
    'start_date': '2020-01-02',
    'end_date': '2020-01-05'
  },
]
 */
public class FriendShipTimeLine {
    public static List<Map<String, Object>> friendshipTimeline(List<Map<String, Object>> friendsAdded, List<Map<String, Object>> friendsRemoved) {
        // HashMap to store active friendships with the key being sorted user ids
        Map<String, String> activeFriendships = new HashMap<>();
        // List to store the final timeline of friendships
        List<Map<String, Object>> friendships = new ArrayList<>();
        System.out.println("Friend Ship Added:"+friendships);
        // Process friends added
        for (Map<String, Object> entry : friendsAdded) {
            // Get and sort user ids
            List<Integer> userIds = (List<Integer>) entry.get("user_ids");
            Collections.sort(userIds); // Sort for consistency
            String userIdsKey = userIds.toString(); // Use string as key

            // Store the created_at time as the start of friendship
            activeFriendships.put(userIdsKey, (String) entry.get("created_at"));
        }

        // Process friends removed
        for (Map<String, Object> entry : friendsRemoved) {
            // Get and sort user ids
            List<Integer> userIds = (List<Integer>) entry.get("user_ids");
            Collections.sort(userIds); // Sort for consistency
            String userIdsKey = userIds.toString(); // Use string as key

            // If the friendship exists in active friendships
            if (activeFriendships.containsKey(userIdsKey)) {
                // Create a timeline entry for the friendship
                Map<String, Object> friendship = new HashMap<>();
                friendship.put("user_ids", userIds);
                friendship.put("start_date", activeFriendships.get(userIdsKey));
                friendship.put("end_date", entry.get("created_at"));

                // Add to the result list
                friendships.add(friendship);

                // Remove from active friendships
                activeFriendships.remove(userIdsKey);
            }
        }

        return friendships;
    }

    public static void doWhileTest(){
        int x= 1;
        do{
            x=x+10;
        }while (x==100);
        System.out.println("Value of X :"+x);
    }
    public static void main(String[] args) {
        // Sample input
        List<Map<String, Object>> friendsAdded = Arrays.asList(
                new HashMap<String, Object>() {{
                    put("user_ids", Arrays.asList(1, 2));
                    put("created_at", "2020-01-01");
                }},
                new HashMap<String, Object>() {{
                    put("user_ids", Arrays.asList(3, 2));
                    put("created_at", "2020-01-02");
                }},
                new HashMap<String, Object>() {{
                    put("user_ids", Arrays.asList(2, 1));
                    put("created_at", "2020-02-02");
                }},
                new HashMap<String, Object>() {{
                    put("user_ids", Arrays.asList(4, 1));
                    put("created_at", "2020-02-02");
                }}
        );

        List<Map<String, Object>> friendsRemoved = Arrays.asList(
                new HashMap<String, Object>() {{
                    put("user_ids", Arrays.asList(2, 1));
                    put("created_at", "2020-01-03");
                }},
                new HashMap<String, Object>() {{
                    put("user_ids", Arrays.asList(2, 3));
                    put("created_at", "2020-01-05");
                }},
                new HashMap<String, Object>() {{
                    put("user_ids", Arrays.asList(1, 2));
                    put("created_at", "2020-02-05");
                }}
        );

        // Get the friendship timeline
        List<Map<String, Object>> result = friendshipTimeline(friendsAdded, friendsRemoved);

        // Print the result
        for (Map<String, Object> friendship : result) {
            System.out.println(friendship);
        }
        doWhileTest();
    }
}
