package com.app.codes.facebook;
/*
A photography set consists of N cells in a row, numbered from 1 to N in order, and can be represented by a string C of length N.
Each cell i is one of the following types (indicated by Ci, the ith character of C):
If Ci = “P”, it is allowed to contain a photographer
If Ci = “A”, it is allowed to contain an actor
If Ci = “B”, it is allowed to contain a backdrop
If Ci = “.”, it must be left empty
A photograph consists of a photographer, an actor, and a backdrop, such that each of them is placed in a valid cell,
and such that the actor is between the photographer and the backdrop. Such a photograph is considered artistic
if the distance between the photographer and the actor is between X and Y cells (inclusive), and the distance between the actor
 and the backdrop are also between X and Y cells (inclusive).
 The distance between cells i and j is |i−j| (the absolute value of the difference between their indices).
Determine the number of different artistic photographs which could potentially be taken at the set.
Two photographs are considered different if they involve a different photographer cell, actor cell, and/or backdrop cell.

Constraints
1≤N≤200
1≤X≤Y≤N
Sample test case #1
N = 5
C = APABA
X = 1
Y = 2
Expected Return Value = 1
Sample test case #2
N = 5
C = APABA
X = 2
Y = 3
Expected Return Value = 0
Sample test case #3
N = 8
C = .PBAAP.B
X = 1
Y = 3
Expected Return Value = 3


 */
public class ArtisticPhotographs {


    public static int getArtisticPhotographCount1(int N, String C, int X, int Y) {
        int[] B = new int[N + 1], P = new int[N + 1];
        int ans = 0;

        for(int i = 1;i <= N;i++) {
            char curr = C.charAt(i - 1);
            P[i] = P[i - 1] + ((curr == 'P') ? 1 : 0);
            B[i] = B[i - 1] + ((curr == 'B') ? 1 : 0);
        }

        for(int i = 0;i < N;i++) {
            if(C.charAt(i) == 'A') {
                int fstart = (i + X) <= N ? (i + X) : N;
                int fend = (i + Y + 1) <= N ? (i + Y + 1) : N;
                int bend = (i - X + 1) >= 0 ? (i - X + 1) : 0;
                int bstart = (i - Y) >= 0 ? (i - Y) : 0;
                ans += (P[fend] - P[fstart]) * (B[bend] - B[bstart]);
                ans += (B[fend] - B[fstart]) * (P[bend] - P[bstart]);
            }
        }

        return ans;
    }

    public static int getArtisticPhotographCount(int N, String C, int X, int Y) {
        int[] B = new int[N + 1];
        int[] P = new int[N + 1];
        int ans = 0;

        for (int i = 1; i <= N; i++) {
            char curr = C.charAt(i - 1);
            P[i] = P[i - 1] + (curr == 'P' ? 1 : 0);
            B[i] = B[i - 1] + (curr == 'B' ? 1 : 0);
        }

        for (int i = 0; i < N; i++) {
            if (C.charAt(i) == 'A') {
                int fstart = Math.min(i + X, N);
                int fend = Math.min(i + Y + 1, N);
                int bend = Math.max(i - X + 1, 0);
                int bstart = Math.max(i - Y, 0);

                ans += (P[fend] - P[fstart]) * (B[bend] - B[bstart]);
                ans += (B[fend] - B[fstart]) * (P[bend] - P[bstart]);
            }
        }

        return ans;
    }


    public static int countArtisticPhotographs(int N, String C, int X, int Y) {
        int count = 0;

        for (int photographer = 0; photographer < N; photographer++) {
            for (int actor = 0; actor < N; actor++) {
                for (int backdrop = 0; backdrop < N; backdrop++) {
                    if (isValidPhotograph(N, C, X, Y, photographer, actor, backdrop)) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private static boolean isValidPhotograph(int N, String C, int X, int Y, int photographer, int actor, int backdrop) {
        if (actor <= photographer || actor >= backdrop) {
            return false;
        }

        int distPhotographerActor = Math.abs(photographer - actor);
        int distActorBackdrop = Math.abs(actor - backdrop);

        return distPhotographerActor >= X && distPhotographerActor <= Y && distActorBackdrop >= X && distActorBackdrop <= Y
                && C.charAt(photographer) == 'P' && C.charAt(actor) == 'A' && C.charAt(backdrop) == 'B';
    }


    public static int getArtisticPhotographCount2(int numCells, String cellTypes, int minDistance, int maxDistance) {
        int[] backdropCounts = new int[numCells + 1];
        int[] photographerCounts = new int[numCells + 1];
        int artisticPhotographs = 0;

        // Calculate the cumulative counts of photographers and backdrops
        for (int i = 1; i <= numCells; i++) {
            char cellType = cellTypes.charAt(i - 1);
            photographerCounts[i] = photographerCounts[i - 1] + (cellType == 'P' ? 1 : 0);
            backdropCounts[i] = backdropCounts[i - 1] + (cellType == 'B' ? 1 : 0);
        }

        // Iterate through the cells to find the artistic photographs
        for (int i = 0; i < numCells; i++) {
            if (cellTypes.charAt(i) == 'A') {
                int frontStart = Math.min(i + minDistance, numCells);
                int frontEnd = Math.min(i + maxDistance + 1, numCells);
                int backEnd = Math.max(i - minDistance + 1, 0);
                int backStart = Math.max(i - maxDistance, 0);

                // Calculate the number of artistic photographs using cumulative counts
                artisticPhotographs += (photographerCounts[frontEnd] - photographerCounts[frontStart])
                        * (backdropCounts[backEnd] - backdropCounts[backStart]);
                artisticPhotographs += (backdropCounts[frontEnd] - backdropCounts[frontStart])
                        * (photographerCounts[backEnd] - photographerCounts[backStart]);
            }
        }

        return artisticPhotographs;
    }


    public static void main(String[] args) {
        // Test cases
        System.out.println(getArtisticPhotographCount(5, "APABA", 1, 2));  // Expected: 1
        System.out.println(getArtisticPhotographCount(5, "APABA", 2, 3));  // Expected: 0
        System.out.println(getArtisticPhotographCount(8, ".PBAAP.B", 1, 3));  // Expected: 3
        System.out.println(getArtisticPhotographCount2(5, "APABA", 1, 2));  // Expected: 1
        System.out.println(getArtisticPhotographCount2(5, "APABA", 2, 3));  // Expected: 0
        System.out.println(getArtisticPhotographCount2(8, ".PBAAP.B", 1, 3));  // Expected: 3
    }
}
