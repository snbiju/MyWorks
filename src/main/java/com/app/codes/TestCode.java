package com.app.codes;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TestCode {

    // snack bowl get it

    Map <String ,Snacks> voteMap = new LinkedHashMap<>();
    int count =0;
    public String getSnack(){
        ArrayList<String> list = new ArrayList<>(voteMap.keySet());
        ArrayList<Snacks> valueList = new ArrayList<>(voteMap.values());
        int call = getRandomNumber(0,list.size());
        System.out.println(list);
        System.out.println(call);
        System.out.println(valueList);
        return list.get(call);
    }

    private int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) );
    }

    public void getVote(String name){
        count=count+1;
        if(voteMap.get(name)==null){
            voteMap.put(name,new Snacks(1,1/count));
            getMapUpdated();
        }else {
            getMapUpdated();

        }

    }

    private void getMapUpdated(){
        for (Map.Entry<String,Snacks> snacks:voteMap.entrySet()
        ) {
            Snacks localSnacks = voteMap.get(snacks.getKey());
            localSnacks.setCount(localSnacks.getCount()+1);
            System.out.println("count inside:"+localSnacks.getCount());
            double per=localSnacks.getCount()/count;
            System.out.println("percentage:"+per);
            localSnacks.setPercentage(localSnacks.getCount()/count);
            voteMap.put(snacks.getKey(),localSnacks);
        }
    }

    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        List<Map.Entry<K, V>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());

        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }

    public static void main(String[] args) {
        TestCode testCode = new TestCode();
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
        for(int i=0;i<50;i++) {
            System.out.println(testCode.getSnack());
        }
    }

    class Snacks{
        int count;
        double percentage;

        public Snacks(int count, double percentage) {
            this.count = count;
            this.percentage = percentage;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public double getPercentage() {
            return percentage;
        }

        public void setPercentage(double percentage) {
            this.percentage = percentage;
        }

        @Override
        public String toString() {
            return "Snacks{" +
                    "count=" + count +
                    ", percentage=" + percentage +
                    '}';
        }
    }
}
