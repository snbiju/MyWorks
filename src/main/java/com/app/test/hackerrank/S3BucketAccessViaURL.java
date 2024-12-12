package com.app.test.hackerrank;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class S3BucketAccessViaURL {
    public static void main(String[] args) {
        try {
            StringBuilder result = new StringBuilder();
            URL url = new URL("https://challenges.hackajob.co/swapi/api/films/?format=json");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            rd.close();

            JsonObject jsonObject = JsonParser.parseString(result.toString()).getAsJsonObject();

            System.out.println(jsonObject.getAsJsonArray("results").get(0).getAsJsonObject().get("title"));
            System.out.println(jsonObject.getAsJsonArray("results").asList());

        } catch (Exception e) {}

        try {
            StringBuilder result = new StringBuilder();
            URL url = new URL("https://s3.eu-west-1.amazonaws.com/hackajob-assets1.p.hackajob/challenges/football_session/football.json");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            rd.close();

            JsonObject jsonObject = JsonParser.parseString(result.toString()).getAsJsonObject();
            System.out.println(jsonObject.getAsJsonArray("rounds").asList());

        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }
    }
}
