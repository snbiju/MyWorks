package com.app.codes.hackerrank;

import java.util.ArrayList;
import java.util.List;

public class AngryProfessor {
    /**
     * A Discrete Mathematics professor has a class of students. Frustrated with
     * their lack of discipline, he decides to cancel class if fewer than K
     * students are present when class starts.
     *
     * Given the arrival time of each student, determine if the class is
     * canceled.
     *
     * @param students
     * @param threshold
     */
    private static String angryProf(int[] students, int threshold) {
        List<Integer> earlyStudents = new ArrayList<>();
        List<Integer> lateStudents = new ArrayList<>();

        for (int i : students) {
            if (i > 0)
                lateStudents.add(i);
            else
                earlyStudents.add(i);
        }

        if (earlyStudents.size() < threshold)
            return "YES";
        return "NO";
    }
}
