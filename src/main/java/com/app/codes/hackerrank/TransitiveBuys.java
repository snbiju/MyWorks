package com.app.codes.hackerrank;
/*

Consider a database of companies, where some companies are known to buy products from other companies.
In this scenario, companies may want to know all the companies they buy from directly and indirectly (possibly over multiple steps).
To model this scenario, let us denote the directed "buys" relationship between company A and company B
as the ordered pair (A, B). We can define the "buys" relationship to be transitive, to model indirect buys.
That is: given there exists a "buys" relation between company A and B, denoted (A,B), and there exists a
"buys" relation between company B and C, denoted (B,C), then we can infer the existence of a transitive "buys" relation (A, C).

Implement a function that receives known "buys" relations as a list of pairs and returns as output the total
number of previously unknown "buys" relations that are infer via transitivity.

Input
2
A B
B C
output
1

Explanation
From the known buys relations in the sample, we can find a company A that buys from B:(A,B).
We can also prove that B buys from C(B,C) Therefore we can conclude that A indirectly buys from C,(B,C)
There are no more new facts based on the knowledge that A buys from B and C, and B buys from C,
so the function should return 1 for the 1 new relation that was created.
Company names are always single characters (up to 255 possible ASCil characters). The maximum input size is 255

Input
1
A A

output
0
 */
import java.util.*;

public class TransitiveBuys {

    public static void main(String[] args) {

        int n=2;


        char[][] buysRelationships = new char[n][n];
        buysRelationships[0][0]='A';
        buysRelationships[0][1]='B';
        buysRelationships[1][0]='B';
        buysRelationships[1][1]='C';
      /*  buysRelationships[2][0]='C';
        buysRelationships[2][1]='A';*/

        char[][] buysRelationships1 = new char[1][2];
        buysRelationships1[0][0] = 'A';
        buysRelationships1[0][1] = 'A';



        int result = countTransitiveBuys1(1, buysRelationships1);
        System.out.println("Number of transitive buys relationships: " + result);
        System.out.println("Number of trasitive buys relationships with 2:"+countTransitiveBuys1( n,buysRelationships));

    }

    public static int countTransitiveBuys1(int n, char[][] buysRelations) {
        int count = 0;

        Set<Pair<Character, Character>> transitiveBuys = new HashSet<>();

        for (int i = 0; i < n; i++) {
            char companyA = buysRelations[i][0];
            char companyB = buysRelations[i][1];

            for (int j = 0; j < n; j++) {
                if(n<=1 && buysRelations[j][0]==buysRelations[j][1]){
                     break;
                }
                if (buysRelations[j][1] == companyA) {
                    Pair<Character, Character> newRelation = new Pair<>(companyB, buysRelations[j][0]);
                    if (transitiveBuys.add(newRelation)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static int countTransitiveBuys(int n,char[][] relationships) {
        int count = 0;
        if(n<=1 && relationships[0][0]==relationships[0][1]){
            return count;
        }
        Set<Character> setA = new HashSet<>();
        Set<Character> setB = new HashSet<>();

        for (int i = 0; i < n; i++) {
            setA.add(relationships[i][0]);
            setB.add(relationships[i][1]);

            if (setA.contains(relationships[i][1]) || setB.contains(relationships[i][0])) {
                count++;
            }

            setA.addAll(setB);
            setB.addAll(setA);
        }

        return count;
    }

    static class Pair<K, V> {
        private final K key;
        private final V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Pair<?, ?> pair = (Pair<?, ?>) obj;
            return key.equals(pair.key) && value.equals(pair.value);
        }

        @Override
        public int hashCode() {
            return key.hashCode() ^ value.hashCode();
        }
        @Override
        public String toString() {
            return "Pair{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }
}

