package com.app.codes.practice;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UnicodeGridDecoder {

    public static void decodeUnicodeGrid(String url) {
        try {
            // Fetch the document content
            Document doc = Jsoup.connect(url).get();

            // Find the first table in the document
            Element table = doc.selectFirst("table");
            if (table == null) {
                System.out.println("No table found in the document.");
                return;
            }

            // Parse the table into rows and cells
            Map<String, String> grid = new HashMap<>();
            Elements rows = table.select("tr");
            boolean isHeaderRow = true;

            for (Element row : rows) {
                Elements cells = row.select("td");

                // Skip the header row
                if (isHeaderRow) {
                    isHeaderRow = false;
                    continue;
                }

                if (cells.size() < 3) {
                    System.out.println("Skipping invalid row: " + row.text());
                    continue;
                }

                try {
                    int x = Integer.parseInt(cells.get(0).text().trim());
                    String character = cells.get(1).text().trim();
                    int y = Integer.parseInt(cells.get(2).text().trim());

                    // Use a map with "(x, y)" as the key
                    grid.put(x + "," + y, character);

                } catch (NumberFormatException e) {
                    System.out.println("Skipping invalid row: " + row.text());
                }
            }

            if (grid.isEmpty()) {
                System.out.println("No valid grid data found.");
                return;
            }

            // Determine grid boundaries
            int minX = Integer.MAX_VALUE, maxX = Integer.MIN_VALUE;
            int minY = Integer.MAX_VALUE, maxY = Integer.MIN_VALUE;

            for (String key : grid.keySet()) {
                String[] parts = key.split(",");
                int x = Integer.parseInt(parts[0]);
                int y = Integer.parseInt(parts[1]);

                minX = Math.min(minX, x);
                maxX = Math.max(maxX, x);
                minY = Math.min(minY, y);
                maxY = Math.max(maxY, y);
            }

            // Print the grid from maxY to minY
            for (int y = maxY; y >= minY; y--) { // Reverse y-order
                StringBuilder row = new StringBuilder();
                for (int x = minX; x <= maxX; x++) {
                    String key = x + "," + y;
                    row.append(grid.getOrDefault(key, " "));
                }
                System.out.println(row);
            }

        } catch (IOException e) {
            System.out.println("Error fetching document: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        decodeUnicodeGrid("https://docs.google.com/document/d/e/2PACX-1vQGUck9HIFCyezsrBSnmENk5ieJuYwpt7YHYEzeNJkIb9OSDdx-ov2nRNReKQyey-cwJOoEKUhLmN9z/pub");
        decodeUnicodeGrid("https://docs.google.com/document/d/e/2PACX-1vRMx5YQlZNa3ra8dYYxmv-QIQ3YJe8tbI3kqcuC7lQiZm-CSEznKfN_HYNSpoXcZIV3Y_O3YoUB1ecq/pub");
    }
}
