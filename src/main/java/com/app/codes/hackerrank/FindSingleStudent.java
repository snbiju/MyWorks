package com.app.codes.hackerrank;
/*


A class of students have a project to work on in pairs. Everyone in the class found a partner, apart from one student.
Using the list provided (which details every student in the class represented by the number of their team), find the student with no partner.

Note that the number of teams can represent either: only two students or the single student.
Try to find the most efficient solution!

INPUT
int[]    student_list
^^ this contains students represented by their team number

OUTPUT
int    single_student_number

CONSTRAINTS
2 <= student_list[i] <= 100000
3 <= i <= 10000

EXAMPLE
Input
[2,4,5,4,2]
Output
5


Input:
int[] student_list: 5,3,2,2,3,5,4,6,9,6,4,12,8,9,12
Output:
Expected:
8
Input:
int[] student_list: 2,2,10,5,4,6,7,5,8,8,6,4,7
Output:
Expected:
10
Input:
int[] student_list: 2015,2000,1092,2042,2016,2015,2000,1994,23,1092,2042,23,1994
Output:
Expected:
2016

Input:
int[] student_list: 53491,62276,82233,66051,97664,27657,45882,46503,27064,64689,70329,62843,84840,53491,62276,82233,66051,97664,27657,45882,46503,27064,64689,70329,62843,84840,1337
Output:
Expected:
1337
 */
public class FindSingleStudent {

    public static int findSingleStudent(int[] studentList) {
        int result = 0;

        // XOR all the team numbers
        for (int student : studentList) {
            result ^= student;
        }

        return result;
    }

    public static void main(String[] args) {
        // Example usage
        int[] studentList = {2, 4, 5, 4, 2};
        int singleStudent = findSingleStudent(studentList);

        System.out.println("The student with no partner is: " + singleStudent);
    }
}
