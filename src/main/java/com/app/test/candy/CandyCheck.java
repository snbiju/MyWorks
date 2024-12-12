package com.app.test.candy;


import java.util.*;

public class CandyCheck {
    Map<String, Snacks> voteMap = new LinkedHashMap<>();
    Random r = new Random();
    int count = 0;

    public String getSnack() {
        ArrayList<String> list = new ArrayList<>(this.voteMap.keySet());
        int call = this.getRandomNumber(0, list.size());

        return list.get(call);
    }

    private int getRandomNumber(int min, int max) {
        return r.nextInt(max);
    }

    public void getVote(String name) {
        ++this.count;
        if (this.voteMap.get(name) == null) {
            this.voteMap.put(name, new Snacks(1, (1 / this.count)));
            this.getMapUpdated();
        } else {
            this.getMapUpdated();
        }

    }

    private void getMapUpdated() {
        Iterator<Map.Entry<String, Snacks>> var1 = this.voteMap.entrySet().iterator();

        while (var1.hasNext()) {
            Map.Entry<String, Snacks> snacks = var1.next();
            Snacks localSnacks = this.voteMap.get(snacks.getKey());
            localSnacks.setCount(localSnacks.getCount() + 1);
            localSnacks.setPercentage((localSnacks.getCount() / this.count));
            this.voteMap.put(snacks.getKey(), localSnacks);
        }

    }

/*    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        List<Map.Entry<K, V>> list = new ArrayList(map.entrySet());
        list.sort(Map.Entry.comparingByValue());
        Map<K, V> result = new LinkedHashMap();
        Iterator var3 = list.iterator();

        while (var3.hasNext()) {
            Map.Entry<K, V> entry = (Map.Entry) var3.next();
            result.put(entry.getKey(), (V) entry.getValue());
        }

        return result;
    }*/

    public static void main(String[] args) {
        CandyCheck testCode = new CandyCheck();
        testCode.getVote("SNIKERS");
        testCode.getVote("SNIKERS");
        testCode.getVote("SNIKERS");
        testCode.getVote("SNIKERS");
        testCode.getVote("SNIKERS");
        testCode.getVote("MARS");
        testCode.getVote("BOUNDIES");
        testCode.getVote("BOUNDIES");
        testCode.getVote("BOUNDIES");
        testCode.getVote("BOUNDIES");
        testCode.getVote("MILKies");
        testCode.getVote("CRUNCH");
        testCode.getVote("CRUNCH");
        testCode.getVote("CRUNCH");
        testCode.getVote("BARS");

        for (int i = 0; i < 50; ++i) {
            System.out.println(testCode.getSnack());
        }
    }
}
