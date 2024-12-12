package com.app.test.ubs;

/*/

Using Java write a simple program that calculates the price of a basket of shopping.

The solution should be accomplished in roughly two hours.
Items are presented one at a time, in a list, identified by name - for example "Apple" or "Banana".

Multiple items are present multiple times in the list, so for example ["Apple", "Apple", "Banana"] is a basket with two apples and one banana.

Items are priced as follows:

- Apples are 35p each

- Bananas are 20p each

- Melons are 50p each, but are available as ‘buy one get one free’

- Limes are 15p each, but are available in a ‘three for the price of two’ offer



Given a list of shopping, calculate the total cost of those items.
 */

import java.util.HashMap;
import java.util.Map;

public class ShoppingBasket {

    // Pricing map to store the price of each item
    private static final Map<String, Integer> pricing = new HashMap<>();

    // Initialize pricing map with item prices
    static {
        pricing.put("Apple", 35);
        pricing.put("Banana", 20);
        pricing.put("Melon", 50);
        pricing.put("Lime", 15);
    }

    // Method to calculate the total cost of shopping basket
    public static int calculateTotalCost(String[] basket) {
        int totalCost = 0;
        Map<String, Integer> itemCount = new HashMap<>();

        // Count the occurrences of each item in the basket
        for (String item : basket) {
            itemCount.put(item, itemCount.getOrDefault(item, 0) + 1);
        }

        // Calculate the total cost based on pricing rules
        for (Map.Entry<String, Integer> entry : itemCount.entrySet()) {
            String item = entry.getKey();
            int count = entry.getValue();
            int price = pricing.get(item);

            if (item.equals("Melon")) {
                // Apply 'buy one get one free' offer for Melons
                totalCost += (count / 2 + count % 2) * price;
            } else if (item.equals("Lime")) {
                // Apply 'three for the price of two' offer for Limes
                totalCost += (count / 3 * 2 + count % 3) * price;
            } else {
                totalCost += count * price;
            }
        }

        return totalCost;
    }

    public static void main(String[] args) {
        String[] basket1 = {"Apple", "Apple", "Banana"};
        String[] basket2 = {"Melon", "Melon", "Banana", "Banana", "Lime", "Lime", "Lime", "Lime"};
        String[] basket3 = {"Melon", "Melon", "Melon", "Lime", "Lime", "Lime", "Lime"};

        System.out.println("Total cost of basket 1: " + calculateTotalCost(basket1) + "p");
        System.out.println("Total cost of basket 2: " + calculateTotalCost(basket2) + "p");
        System.out.println("Total cost of basket 3: " + calculateTotalCost(basket3) + "p");
    }
}

