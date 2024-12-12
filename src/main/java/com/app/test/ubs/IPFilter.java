package com.app.test.ubs;

import java.util.*;
import java.util.regex.Pattern;

public class IPFilter {
    public static List<Integer> validateRequests(List<String> blacklisted_ips, List<String> requests) {
        // Convert blacklisted IP patterns to regex patterns
        List<Pattern> patterns = new ArrayList<>();
        for (String ip : blacklisted_ips) {
            patterns.add(convertToRegex(ip));
        }

        // Map to track timestamps of requests per IP
        Map<String, List<Integer>> requestTimestamps = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < requests.size(); i++) {
            String request = requests.get(i);
            int currentTime = i;
            boolean blocked = isBlocked(request, patterns);

            if (!blocked) {
                blocked = isFrequentRequester(request, currentTime, requestTimestamps);
            }

            if (!blocked) {
                result.add(0);
                requestTimestamps.computeIfAbsent(request, k -> new ArrayList<>()).add(currentTime);
            } else {
                result.add(1);
            }
        }

        return result;
    }

    // Method to convert IP pattern to regex
    private static Pattern convertToRegex(String ipPattern) {
        String regex = ipPattern.replace(".", "\\.")
                .replace("*", ".*");
        return Pattern.compile(regex);
    }

    // Method to check if a request is blocked by blacklisted patterns
    private static boolean isBlocked(String request, List<Pattern> patterns) {
        for (Pattern pattern : patterns) {
            if (pattern.matcher(request).matches()) {
                return true;
            }
        }
        return false;
    }

    // Method to check if a request is blocked due to frequency
    private static boolean isFrequentRequester(String request, int currentTime, Map<String, List<Integer>> requestTimestamps) {
        if (!requestTimestamps.containsKey(request)) {
            return false;
        }

        List<Integer> timestamps = requestTimestamps.get(request);
        // Remove timestamps that are older than 5 seconds from the current time
        timestamps.removeIf(time -> currentTime - time >= 5);

        // Check if there are at least 2 requests in the last 5 seconds
        return timestamps.size() >= 2;
    }
    // Main method for testing
    public static void main(String[] args) {
        List<String> blacklisted_ips = Arrays.asList("111.*", "123.*", "34.*");
        List<String> requests = Arrays.asList("121.1.23.34", "121.1.23.34", "121.1.23.34", "34.1.23.34", "121.1.23.34", "121.1.23.34", "121.1.23.34");
        List<Integer> result = validateRequests(blacklisted_ips, requests);
        System.out.println(result); // Expected Output: [1, 0, 0, 1, 1, 0, 0]


        // Test cases
        List<String> blacklisted_ips1 = List.of("111.*.255", "12.*");
        List<String> requests1 = List.of("121.3.5.255", "12.13.5.255", "111.3.5.255", "121.3.5.255");
        System.out.println(validateRequests(blacklisted_ips1, requests1));  // Output: [0, 0, 1, 0]

        List<String> blacklisted_ips2 = List.of("111.111.1.1");
        List<String> requests2 = List.of("111.111.1.1");
        System.out.println(validateRequests(blacklisted_ips2, requests2));  // Output: [1]



    }
}