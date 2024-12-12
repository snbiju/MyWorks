package com.app.codes.candy;
/*

Time Complexity:

getSnack method:
Creating a list from the keys of the voteMap takes O(N), where N is the number of snacks.
Getting a random index using getRandomNumber takes O(1).
So, the overall time complexity is O(N).

getRandomNumber method:
Generating a random number using Random.nextInt takes O(1).

voteForSnack method:
The compute method takes O(1) time.
The overall time complexity is O(1).

Space Complexity:
The voteMap stores information about each snack.

The space complexity for the map is O(N), where N is the number of unique snacks.
Additional space is used for local variables (snackList, randomIndex, etc.) and the Snacks objects.

The space complexity for these variables is O(1) since they don't scale with input size.

In summary,
the overall time complexity is O(N), and the space complexity is O(N) due to the voteMap.

 */
import java.util.*;

public class VotingSystem {
    private final Map<String, Snacks> voteMap = new LinkedHashMap<>();
    private final Random random = new Random();
    private int count = 0;

    public String getSnack() {
        List<String> snackList = new ArrayList<>(voteMap.keySet());
        int randomIndex = getRandomNumber(snackList.size());

        return snackList.get(randomIndex);
    }

    private int getRandomNumber(int max) {
        return random.nextInt(max);
    }

    public  void voteForSnack(String name) {
        count++;

        voteMap.compute(name, (key, snacks) -> {
            if (snacks == null) {
                return new Snacks(1, 1.0 / count);
            } else {
                snacks.setCount(snacks.getCount() + 1);
                snacks.setPercentage(snacks.getCount() / (double) count);
                return snacks;
            }
        });
    }

    public static void main(String[] args) {
        VotingSystem testCode = new VotingSystem();
        String snikers= "SNIKERS";
        String mars ="MARS";
        String bondies="BOUNDIES";
        String crunch="CRUNCH";
        String bars="BARS";
        String milkies="MILKIES";

        testCode.voteForSnack(snikers);
        testCode.voteForSnack(snikers);
        testCode.voteForSnack(snikers);
        testCode.voteForSnack(snikers);
        testCode.voteForSnack(snikers);
        testCode.voteForSnack(mars);
        testCode.voteForSnack(bondies);
        testCode.voteForSnack(bondies);
        testCode.voteForSnack(bondies);
        testCode.voteForSnack(bondies);
        testCode.voteForSnack(milkies);
        testCode.voteForSnack(crunch);
        testCode.voteForSnack(crunch);
        testCode.voteForSnack(crunch);
        testCode.voteForSnack(bars);

        for (int i = 0; i < 50; ++i) {
            System.out.println(testCode.getSnack());
        }
    }
}
