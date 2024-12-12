package com.app.test;
/*
We are writing a tool to help users manage their calendars. Given an unordered list of times of day when someone is busy, write a function that tells us whether they're available during a specified period of time.

Each time is expressed as an integer using 24-hour notation, such as 1200 (12:00), 1530 (15:30), or 800 (8:00).

Sample input:

meetings = [
  [1230, 1300], // 12:30 PM to 1:00 PM
  [845, 900],   //  8:45 AM to 9:00 AM
  [1300, 1500]  //  1:00 PM to 3:00 PM
]

Expected output:

isAvailable(meetings, 915, 1215)   => true
isAvailable(meetings, 900, 1230)   => true
isAvailable(meetings, 850, 1240)   => false
isAvailable(meetings, 1200, 1300)  => false
isAvailable(meetings, 700, 1600)   => false
isAvailable(meetings, 800, 845)    => true
isAvailable(meetings, 1500, 1800)  => true
isAvailable(meetings, 845, 859)    => false
isAvailable(meetings, 846, 900)    => false
isAvailable(meetings, 846, 859)    => false
isAvailable(meetings, 845, 900)    => false
isAvailable(meetings, 2359, 2400)  => true
isAvailable(meetings, 930, 1600)   => false
isAvailable(meetings, 800, 850)    => false
isAvailable(meetings, 1400, 1600)  => false
isAvailable(meetings, 1300, 1501)  => false

n = number of meetings
r = total minutes in range of all meetings

*/

import java.io.*;
import java.util.*;

public class MeetingCalender {

    public static boolean isAvaliable(int[][] meetings, int start, int end) {
        boolean flag = false;
        for (int i = 0; i < meetings.length; i++) {
            if (meetings[i][0] < start) {
                for (int j = 0; j < meetings.length; j++) {
                    //break;
                    flag = meetings[j][1] > end;
                }

            }
        }

        return flag;
    }


    /**
     * for x in appointments:
     * for y in appointments:
     * if (not x.hasConflict) and (x.end >= y.start) and (x.start = A[y].start) and (A[x].start A[x].end:
     * # No conflict, and x cannot conflict with later appts, so skip them
     * break
     *
     * The second method is certainly an improvement over the first, but there may still be a further improvement I'm not seeing. I don't like the fact that my worst case is still O(n*n)...
     *
     * @param argv
     */
    public static void main(String[] argv) {
        int[][] meetings = {
                {1230, 1300},
                {845, 900},
                {1300, 1500},
        };
        System.out.println( " {1230, 1300},\n" +
                " {845, 900},\n" +
                " {1300, 1500},");
     /*   System.out.println(isAvaliable(meetings, 915, 1215));

        System.out.println(isAvaliable(meetings, 915, 1215));
        System.out.println(isAvaliable(meetings, 900, 1230));
        System.out.println(isAvaliable(meetings, 850, 1240));
        System.out.println(isAvaliable(meetings, 1200, 1300));
        System.out.println(isAvaliable(meetings, 700, 1600));
        System.out.println(isAvaliable(meetings, 800, 845));
        System.out.println(isAvaliable(meetings, 1500, 1800));
        System.out.println(isAvaliable(meetings, 845, 859));
        System.out.println(isAvaliable(meetings, 846, 900));
        System.out.println(isAvaliable(meetings, 846, 859));
        System.out.println(isAvaliable(meetings, 845, 900));
        System.out.println(isAvaliable(meetings, 2359, 2400));
        System.out.println(isAvaliable(meetings, 930, 1600));
        System.out.println(isAvaliable(meetings, 800, 850));
        System.out.println(isAvaliable(meetings, 1400, 1600));
        System.out.println(isAvaliable(meetings, 1300, 1501));*/


        System.out.println("****************");

        System.out.println("isAvailable(meetings, 915, 1215)   => true");
        System.out.println(isAvaliable(meetings, 915, 1215));
        System.out.println("isAvailable(meetings, 900, 1230)   => true");
        System.out.println(isAvaliable(meetings, 900, 1230));
        System.out.println("isAvailable(meetings, 850, 1240)   => false");
        System.out.println(isAvaliable(meetings, 850, 1240));
        System.out.println("isAvailable(meetings, 1200, 1300)  => false");
        System.out.println(isAvaliable(meetings, 1200, 1300));
        System.out.println("isAvailable(meetings, 700, 1600)   => false");
        System.out.println(isAvaliable(meetings, 700, 1600) );
        System.out.println("isAvailable(meetings, 800, 845)    => true");
        System.out.println(isAvaliable(meetings, 800, 845) );
        System.out.println("isAvailable(meetings, 1500, 1800)  => true");
        System.out.println(isAvaliable(meetings, 1500, 1800));
        System.out.println("isAvailable(meetings, 845, 859)    => false");
        System.out.println(isAvaliable(meetings, 845, 859));
        System.out.println("isAvailable(meetings, 846, 900)    => false");
        System.out.println(isAvaliable(meetings, 846, 900));
        System.out.println("isAvailable(meetings, 846, 859)    => false");
        System.out.println(isAvaliable(meetings, 846, 859) );
        System.out.println("isAvailable(meetings, 845, 900)    => false");
        System.out.println(isAvaliable(meetings, 845, 900) );
        System.out.println("isAvailable(meetings, 2359, 2400)  => true");
        System.out.println(isAvaliable(meetings, 2359, 2400) );
        System.out.println("isAvailable(meetings, 930, 1600)   => false");
        System.out.println(isAvaliable(meetings, 930, 1600) );
        System.out.println("isAvailable(meetings, 800, 850)    => false");
        System.out.println(isAvaliable(meetings, 800, 850) );
        System.out.println("isAvailable(meetings, 1400, 1600)  => false");
        System.out.println(isAvaliable(meetings, 1400, 1600) );
        System.out.println("isAvailable(meetings, 1300, 1501)  => false");
        System.out.println(isAvaliable(meetings, 1300, 1501) );
    }
}

