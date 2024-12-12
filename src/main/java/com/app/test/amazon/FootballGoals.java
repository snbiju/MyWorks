package com.app.test.amazon;

/*

We want to be able to see how many goals a specific football team in the Premier League scored in total during the 2014/2015 season.
All the information you need is contained in this JSON file: https://s3.eu-west-1.amazonaws.com/hackajob-assets1.p.hackajob/challenges/football_session/football.json

INPUT
string    teamKey
^^ the football team key name (is a parameter of the JSON)

OUTPUT
int    goals
^^ an integer with the total number of goals scored by that team during the session

EXAMPLE
Input
"arsenal"

Output
"X"
^^ number of goals scored by Arsenal in that JSON
 */

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;

public class FootballGoals {// The teamKey is the name of the team eg "arsenal"

    public static void main(String[] args) {
        System.out.println(run("arsenal"));//71
        System.out.println(run("crystalpalace"));//47
    }

    public static int run(String teamKey) {
        /*
         * Write your code below; return type and arguments should be according to the problem's requirements
         */
        Round[] rounds = getSeason().getRounds();

        int goals = 0;
        for (Round round : rounds) {
            goals += getScoreForTeam1(teamKey, round);
            goals += getScoreForTeam2(teamKey, round);
        }
        return goals;
    }

    private static int getScoreForTeam2(String teamKey, Round round) {
        return Arrays.stream(round.getMatches()).filter(p -> p.getTeam2().getKey().equals(teamKey)).mapToInt(i -> i.getScore2()).sum();
    }

    //private static int getScoreForTeam1(String teamKey, Round round, Predicate predicate, ToIntFunction toIntFunction) {
    private static int getScoreForTeam1(String teamKey, Round round) {
        return Arrays.stream(round.getMatches()).filter(p -> p.getTeam1().getKey().equals(teamKey)).mapToInt(i -> i.getScore1()).sum();
    }

    private static Season getSeason() {
        Season season = null;
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

            Gson gson = new Gson();
            season = gson.fromJson(result.toString(), Season.class);
        } catch (Exception e) {
        }
        return season;
    }

    class Match {
        private String date;
        private Team team1;
        private Team team2;
        private int score1;
        private int score2;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public Team getTeam1() {
            return team1;
        }

        public void setTeam1(Team team1) {
            this.team1 = team1;
        }

        public Team getTeam2() {
            return team2;
        }

        public void setTeam2(Team team2) {
            this.team2 = team2;
        }

        public int getScore1() {
            return score1;
        }

        public void setScore1(int score1) {
            this.score1 = score1;
        }

        public int getScore2() {
            return score2;
        }

        public void setScore2(int score2) {
            this.score2 = score2;
        }
    }

    class Season {
        private String name;
        private Round[] rounds;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Round[] getRounds() {
            return rounds;
        }

        public void setRounds(Round[] rounds) {
            this.rounds = rounds;
        }
    }

    class Round {
        private String name;
        private Match[] matches;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Match[] getMatches() {
            return matches;
        }

        public void setMatches(Match[] matches) {
            this.matches = matches;
        }
    }

    class Team {
        private String key;
        private String name;
        private String code;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }
    }
}