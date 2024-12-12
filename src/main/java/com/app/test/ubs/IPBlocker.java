package com.app.test.ubs;

import java.util.*;
import java.util.regex.*;
import java.util.regex.Pattern;

public class IPBlocker {
    public static void main(String[] args) {
        String[] blacklisted_ips = {"*.123.*", "192.168.*.*"};
        String[] requests = {"12.1.123.45", "192.168.1.1", "1.2.3.4", "1.123.435.12", "192.168.2.2", "192.168.2.2"};

        List<Integer> results = processRequests(blacklisted_ips, requests);
        System.out.println(results);


        String[] blacklistedIps = {"111.*", "123.*", "34.*"};
        String[] requestsq = {"121.1.23.34", "121.1.23.34", "121.1.23.34", "34.1.23.34", "121.1.23.34", "121.1.23.34", "121.1.23.34"};
        List<Integer> result = processRequests(blacklistedIps, requestsq);
        System.out.println(result); // Output: [1, 0, 0, 1, 1, 0, 0]
    }

    public static List<Integer> processRequests(String[] blacklisted_ips, String[] requests) {
        List<Pattern> patterns = new ArrayList();
        for (String ip : blacklisted_ips) {
            patterns.add(Pattern.compile(ip.replace(".", "\\.").replace("*", ".*")));
        }

        HashMap<String, LinkedList<Integer>> requestHistory = new HashMap();
        HashSet blockedIPs = new HashSet();
        List<Integer> results = new ArrayList();

        for (int i = 0; i < requests.length; i++) {
            String request = requests[i];
            boolean isBlocked = false;

            // Check if the IP is already blocked
            if (blockedIPs.contains(request)) {
                results.add(1);
                continue;
            }

            // Check if the IP matches any blacklisted regex
            for (Pattern pattern : patterns) {
                if (pattern.matcher(request).matches()) {
                    isBlocked = true;
                    blockedIPs.add(request);
                    break;
                }
            }

            if (!isBlocked) {
                // Check the request history for the IP
                LinkedList<Integer> history = requestHistory.getOrDefault(request, new LinkedList());
                history.add(i);
                while (!history.isEmpty() && i - history.getFirst() > 5) {
                    history.removeFirst();
                }
                requestHistory.put(request, history);

                if (history.size() >= 2) {
                    isBlocked = true;
                    blockedIPs.add(request);
                }
            }

            results.add(isBlocked ? 1 : 0);
        }

        return results;
    }
}
