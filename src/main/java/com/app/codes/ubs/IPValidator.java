package com.app.codes.ubs;

/*
There are n blacklisted IP regexes given as an array of strings,
blacklisted_ips where each string consists of a string of numeric characters,
‘.’ or ‘*’ where “*” represented a wildcard character that can be replaced with 0 or more characters. For example ,
the regex IP “*.123.*” matches with “12.1.123.45”,”1.123.435.12” but not with “1.2.3.4”.

There are q IP request to be processed given as an array of IP address, requests where requests[i] arrives in the ith second.
A request is blocked if it matches any of the blacklisted regex IPs or the IP address has sent at least 2 request in the last 5 seconds which have not been blocked.
Given request and blacklisted-ips, for each request , report 1 if it will be blocked and 0 otherwise.
Note: All Ips are characterised by a string of four integers separated by three dots. "<number>.<number>.<number>.<number>"

Example :
Suppose n=3, blacklisted_ips = [“111.*","123.*”,”34.*”],
q=7, requests=[“121.1.23.34”,”121.1.23.34”,”121.1.23.34”,”34.1.23.34”,”121.1.23.34”,”121.1.23.34”,”121.1.23.34”]

output: [1,0,0,1,1,0,0]

Note: At a time 7 request IP "121.1.23.34" is not blocked because in the last 5 seconds, only the instance which came at time 3 is accepted. The
request which came at time 5 was blocked, so it included in the current count

constraints
1<=n<=10
1<=|blocked_ips[i]|<=15
1<=q<=1000
1<=|requests[i]|<=15


public static List<Integer>  validateREquests(List<STring> backlisted_ips, List<String> requests){}


input

blacklisted_ips [“111.*.255”,”12.”]

requests[“121.3.5.255”,”12.13.5.255”,”111.3.5.255”,”121.3.5.255”]

output : [0,0,1,0]

 */

import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class IPValidator {


    public static List<Integer> validateRequests(List<String> blacklistedIps, List<String> requests) {
        List<Integer> results = new ArrayList<>();
        List<Pattern> compiledRegexes = new ArrayList<>();

        // Compile regex patterns (handle invalid regex)
        for (String regex : blacklistedIps) {
            try {
                compiledRegexes.add(Pattern.compile(convertRegexToPCRE(regex)));
            } catch (PatternSyntaxException e) {
                System.err.println("Invalid regex encountered: " + regex);
            }
        }

        for (String request : requests) {
            boolean blocked = false;

            // Check against compiled regexes
            for (Pattern pattern : compiledRegexes) {
                if (pattern.matcher(request).matches()) {
                    blocked = true;
                    break;
                }
            }

            // Check recent request history (optional for future enhancement)
            // This part is not implemented in the provided prompt

            results.add(blocked ? 1 : 0);
        }

        return results;
    }

    // Converts a simple wildcard regex to PCRE (Perl Compatible Regular Expressions)
    private static String convertRegexToPCRE(String regex) {
        return regex.replace("*", ".*");
    }

    public static List<Integer> validateRequests1(List<String> blacklisted_ips, List<String> requests) {
        List<Integer> results = new ArrayList<>();
        List<Pattern> patterns = new ArrayList<>();

        // Convert blacklisted IPs to regex patterns
        for (String blacklist : blacklisted_ips) {
            String regex = blacklist.replace(".", "\\.").replace("*", ".*");
            patterns.add(Pattern.compile(regex));
        }

        // Check each request against all patterns
        for (String request : requests) {
            boolean isBlacklisted = false;
            for (Pattern pattern : patterns) {
                if (pattern.matcher(request).matches()) {
                    isBlacklisted = true;
                    break;
                }
            }
            results.add(isBlacklisted ? 1 : 0);
        }

        return results;
    }

    public static List<Integer> processRequests1(List<String> blacklistedIps, List<String> requests) {
        List<Integer> result = new ArrayList<>();
        List<Pattern> patterns = new ArrayList<>();

        // Convert blacklisted IPs to regex patterns
        for (String ip : blacklistedIps) {
            String regex = ip.replace(".", "\\.").replace("*", ".*");
            patterns.add(Pattern.compile(regex));
        }

        // Map to store IP address requests with timestamps
        Map<String, List<Instant>> ipRequestMap = new HashMap<>();
        Instant currentTime = Instant.now();

        for (String request : requests) {
            boolean isBlocked = false;

            // Check if the request matches any blacklisted regex
            for (Pattern pattern : patterns) {
                if (pattern.matcher(request).matches()) {
                    isBlocked = true;
                    break;
                }
            }

            if (!isBlocked) {
                // Check the request frequency
                List<Instant> timestamps = ipRequestMap.getOrDefault(request, new ArrayList<>());

                // Remove timestamps older than 5 seconds
                timestamps.removeIf(timestamp -> Duration.between(timestamp, currentTime).getSeconds() > 5);

                if (timestamps.size() >= 2) {
                    isBlocked = true;
                } else {
                    timestamps.add(currentTime);
                    ipRequestMap.put(request, timestamps);
                }
            }

            result.add(isBlocked ? 1 : 0);
        }

        return result;
    }



    public static List<Integer> processRequests(String[] blacklisted_ips, String[] requests) {
        // Step 1: Compile the blacklist regex patterns
        List<Pattern> blacklistPatterns = new ArrayList<>();
        for (String ip : blacklisted_ips) {
            String regex = ip.replace(".", "\\.").replace("*", ".*");
            blacklistPatterns.add(Pattern.compile(regex));
        }

        // Step 2: Track recent requests
        Map<String, LinkedList<Integer>> requestLog = new HashMap<>();

        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < requests.length; i++) {
            String requestIP = requests[i];
            boolean isBlocked = false;

            // Step 3: Check against blacklist
            for (Pattern pattern : blacklistPatterns) {
                if (pattern.matcher(requestIP).matches()) {
                    isBlocked = true;
                    break;
                }
            }

            // Step 4: Check recent requests if not already blocked
            if (!isBlocked) {
                if (!requestLog.containsKey(requestIP)) {
                    requestLog.put(requestIP, new LinkedList<>());
                }
                LinkedList<Integer> timestamps = requestLog.get(requestIP);

                // Remove timestamps older than 5 seconds
                while (!timestamps.isEmpty() && timestamps.getFirst() <= i - 5) {
                    timestamps.removeFirst();
                }

                // Check if there are at least 2 requests in the last 5 seconds
                if (timestamps.size() == 2) {
                    isBlocked = true;
                }

                // Add current request timestamp
                timestamps.addLast(i);
            }

            // Record result
            results.add(isBlocked ? 1 : 0);
        }

        return results;
    }

    public static List<Integer> processRequests(List<String> blacklisted_ips, List<String> requests) {
        // Step 1: Compile the blacklist regex patterns
        List<Pattern> blacklistPatterns = new ArrayList<>();
        for (String ip : blacklisted_ips) {
            String regex = ip.replace(".", "\\.").replace("*", ".*");
            blacklistPatterns.add(Pattern.compile(regex));
        }

        // Step 2: Track recent requests
        Map<String, LinkedList<Integer>> requestLog = new HashMap<>();

        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < requests.size(); i++) {
            String requestIP = requests.get(i);
            boolean isBlocked = false;

            // Step 3: Check against blacklist
            for (Pattern pattern : blacklistPatterns) {
                if (pattern.matcher(requestIP).matches()) {
                    isBlocked = true;
                    break;
                }
            }

            // Step 4: Check recent requests if not already blocked
            if (!isBlocked) {
                if (!requestLog.containsKey(requestIP)) {
                    requestLog.put(requestIP, new LinkedList<>());
                }
                LinkedList<Integer> timestamps = requestLog.get(requestIP);

                // Remove timestamps older than 5 seconds
                while (!timestamps.isEmpty() && timestamps.getFirst() <= i - 5) {
                    timestamps.removeFirst();
                }

                // Check if there are at least 2 requests in the last 5 seconds
                if (timestamps.size() == 2) {
                    isBlocked = true;
                }

                // Add current request timestamp
                timestamps.addLast(i);
            }

            // Record result
            results.add(isBlocked ? 1 : 0);
        }

        return results;
    }

    public static void main(String[] args) {
        // Test cases
        List<String> blacklisted_ips1 = List.of("111.*.255", "12.*");
        List<String> requests1 = List.of("121.3.5.255", "12.13.5.255", "111.3.5.255", "121.3.5.255");
        System.out.println(processRequests(blacklisted_ips1, requests1));  // Output: [0, 0, 1, 0]

        List<String> blacklisted_ips2 = List.of("111.111.1.1");
        List<String> requests2 = List.of("111.111.1.1");
        System.out.println(processRequests(blacklisted_ips2, requests2));  // Output: [1]


        List<String> blacklistedIps = Arrays.asList("*111.*", "123.*", "34.*");
        List<String> requests = Arrays.asList("123.1.23.34", "121.1.23.34", "121.1.23.34", "34.1.23.34", "121.1.23.34", "121.1.23.34", "12.1.23.34");

        List<Integer> result = processRequests(blacklistedIps, requests);
        System.out.println(result);  // Output: [1, 0, 0, 1, 1, 0, 0]

        String[] blocked={"*111.*", "123.*", "34.*"};
        String[] req ={"123.1.23.34", "121.1.23.34", "121.1.23.34", "34.1.23.34", "121.1.23.34", "121.1.23.34", "12.1.23.34"};
        System.out.println( processRequests(blocked,req));  // Output: [1, 0, 0, 1, 1, 0, 0]

        String[] blacklistedips1 = {"111.*.255", "12.*"};
        String[] reques1 = {"121.3.5.255", "12.13.5.255", "111.3.5.255", "121.3.5.255"};
        System.out.println(processRequests(blacklisted_ips1, requests1));  // Output: [0, 0, 1, 0]


    }
}
