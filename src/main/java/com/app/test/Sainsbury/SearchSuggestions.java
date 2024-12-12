package com.app.test.Sainsbury;

/*
Given an array of strings products and a string searchWord. We want to design a system that suggests at most three
product names from products after each character of searchWord is typed. Suggested products should have common prefix
 with the searchWord. If there are more than three products with a common prefix return the three
 lexicographically minimums products.

Return list of lists of the suggested products after each character of searchWord is typed.

Despite the fact that the clues suggest a binary search and a trie, the optimal solution to this problem needs neither.
The substrings formed by adding one letter at a time from the search word (S) are naturally already in lexicographical order,
 as are the results that we're instructed to push into our answer array (ans).

So if we sort the products array (P), we should only ever need to iterate through P once during the entire remaining process
of the solution with a time complexity of O(N). A single binary search would only require log(N) time, but we'd have to
perform M = S.length binary searches, so in total they would take O(M * log(N)) time, compared to
the O(N) time of a simple iteration.

With constraints of 1000 on both M and N, the binary search route would max out at a worse time complexity than iteration.
Regardless, the sort itself, which is required for both, requires O(N * log(N)) time already, so neither option can
decrease the overall time complexity required.

So in order to only require a single pass through P, we should keep track of the current bounds for the range of
matches (left, right), then we'll iterate through the characters (c) of S. At each iteration, we'll first want to move
left forward and right back to narrow the range of matches based on the new value of c.

Then we can add the next three elements of P to our result array (res), as long as they fall inside the range [left, right].
Once that's done, we can add res to ans and move to the next iteration.

Once we've finished iterating through S, we can return ans.

Time Complexity: O(N * log(N)) where N is the length of P
Space Complexity: O(1) excluding output space required for ans

 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class SearchSuggestions {
    public static List<List<String>> suggestedProducts1(List<String> products, String searchWord) {
        Collections.sort(products);
        List<List<String>> result = new ArrayList<>();
        int left = 0;
        int right = products.size() - 1;

        for (int i = 0; i < searchWord.length(); i++) {
            char currentChar = searchWord.charAt(i);
            left = binarySearchLeft(products, currentChar, i, left, right);
            right = binarySearchRight(products, currentChar, i, left, right);

            List<String> suggestions = new ArrayList<>();
            for (int j = 0; j < 3 && left + j <= right; j++) {
                suggestions.add(products.get(left + j));
            }

            result.add(suggestions);
        }

        return result;
    }

    private static int binarySearchLeft(List<String> products, char target, int index, int left, int right) {
        while (left <= right && (products.get(left).length() == index || products.get(left).charAt(index) < target)) {
            left++;
        }
        return left;
    }

    private static int binarySearchRight(List<String> products, char target, int index, int left, int right) {
        while (left <= right && (products.get(right).length() == index || products.get(right).charAt(index) > target)) {
            right--;
        }
        return right;
    }


    public static List<List<String>> suggestedProducts(String[] P, String S) {
        Arrays.sort(P);
        List<List<String>> ans = new ArrayList<>();
        int left = 0, right = P.length - 1;
        for (int i = 0; i < S.length(); i++) {
            List<String> res = new ArrayList<>();
            char c = S.charAt(i);
            while (left <= right && (P[left].length() == i || P[left].charAt(i) < c)) left++;
            while (left <= right && (P[right].length() == i || P[right].charAt(i) > c)) right--;
            for (int j = 0; j < 3 && left + j <= right; j++)
                res.add(P[left+j]);
            ans.add(res);
        }
        return ans;
    }

    public static List<List<String>> suggestedProducts(List<String> P, String S) {
        Collections.sort(P);
        List<List<String>> ans = new ArrayList<>();
        int left = 0, right = P.size() - 1;
        for (int i = 0; i < S.length(); i++) {
            List<String> res = new ArrayList<>();
            char c = S.charAt(i);
            while (left <= right && (P.get(left).length() == i || P.get(left).charAt(i) < c)) left++;
            while (left <= right && (P.get(right).length() == i || P.get(right).charAt(i) > c)) right--;
            for (int j = 0; j < 3 && left + j <= right; j++)
                res.add(P.get(left+j));
            ans.add(res);
        }
        return ans;
    }

    public static void main(String[] args) {
        List<String> products = new ArrayList<>();
        products.add("abcd");
        products.add("abdc");
        products.add("abaa");
        products.add("acbd");
       System.out.println(suggestedProducts(products,"abcd"));  //[[abaa, abcd, abdc], [abaa, abcd, abdc], [abcd], [abcd]]

       List<String> products1= new ArrayList<>();
       products1.add("mobile");
       products1.add("mouse");
       products1.add("moneypot");
       products1.add("monitor");
       products1.add("mousepad");
       System.out.println(suggestedProducts(products1,"mouse"));//[[mobile, moneypot, monitor], [mobile, moneypot, monitor], [mouse, mousepad], [mouse, mousepad], [mouse, mousepad]]
       String[] products04 = {"mobile","mouse","moneypot","monitor","mousepad"};
        System.out.println(suggestedProducts(products04, "mouse"));
       List<String> product2= new ArrayList<>();
       product2.add("havana");
       String[] product05={"havana"};
       // System.out.println(suggestedProducts(product2, "tatiana"));//[[], [], [], [], [], [], []]
      //  System.out.println(suggestedProducts(product05, "tatiana"));//[[], [], [], [], [], [], []]


/*
       int sum= Stream.iterate(new int[]{0,1},
                       tint sum =Stream.iterate(new int[]{0,1},x->new int[]{x[1],x[0]+x[1]}))
               .limit(n)
               .map(x->x[0])
               .collect(Collectors.toList())
               .stream()
               .distinct()
               .filter(i->i%2==0)
               .mapToInt(i->i).sum();
       return sum;
       what is the different result for n=7 and n=8*/


    }
}