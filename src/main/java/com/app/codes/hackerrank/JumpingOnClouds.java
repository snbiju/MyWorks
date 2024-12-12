package com.app.codes.hackerrank;
/*

Emma is playing a new mobile game that starts with consecutively numbered clouds.
Some clouds are thunderheads and others are cumulus. She can jump on any cumulus cloud having a number that is equal
to the current cloud number plus 1 or 2.
Jumping on the Clouds
 */
public class JumpingOnClouds {

    public static int jumpingOnClouds(int[] clouds) {
        int jumps = 0;
        int i = 0;

        while (i < clouds.length - 1) {
            if (i + 2 < clouds.length && clouds[i + 2] == 0) {
                // Jump 2 clouds ahead
                i += 2;
            } else {
                // Jump 1 cloud ahead
                i += 1;
            }

            jumps++;
        }

        return jumps;
    }

    public static void main(String[] args) {
        int[] clouds = {0, 0, 1, 0, 0, 1, 0};

        int result = jumpingOnClouds(clouds);
        System.out.println(result);
    }
}

