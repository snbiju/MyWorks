package com.app.codes.hackerrank;
/*

Wouldn't it be neat if every year, your birthday would fall on a Friday, Saturday or Sunday?
Given a certain date, return a string with the day of the week and the year it will fall in a weekend, starting with the year (2016). Do this for 50 years in the future.

INPUT
string    date_of_birth
                ^ with this format: dd-mm

OUTPUT
string    future_dates
                ^ wday-yyyy wday-yyyy …
                (where _wday_ can be any of this three values: Fry, Sat, Sun)
                Every date should be separated by one space.

EXAMPLE
Input
"23-10"

Output
"Sun-2016 Fri-2020 Sat-2021 Sun-2022 Fri-2026 Sat-2027 Sat-2032 Sun-2033 Fri-2037 Sat-2038
Sun-2039 Fri-2043 Sun-2044 Fri-2048 Sat-2049 Sun-2050 Fri-2054 Sat-2055 Sat-2060 Sun-2061 Fri-2065"


Input:
string birthday_date: "29-02"
Output:
Expected:
Sat-2020 Sun-2032 Fri-2036 Sat-2048 Sun-2060 Fri-2064

 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

class LeapYearDates {

    public static String calculateFutureDates(String dateOfBirth) throws ParseException {
        StringBuilder result = new StringBuilder();

        String[] arr = dateOfBirth.split("-");
        String date = arr[0];
        String month = arr[1];

        for (int year = 2016; year < 2066; year++) {
            if(dateOfBirth.equalsIgnoreCase("29-02")){
                if(isLeapYear(year)){
                    if(futureDate( date, month, year)!=null) {
                        result.append(futureDate(date, month, year)).append(" ");
                    }
                }
            }else {
                if(futureDate( date, month, year)!=null) {
                    result.append(futureDate(date, month, year)).append(" ");
                }
            }
        }

        return result.toString().trim();
    }

    private static String futureDate( String date, String month, int year) throws ParseException {
        String futureDate = null;
        String totalDate = year + "-" + month + "-" + date;

        int dayOfWeek = getWeekday(totalDate);

        if (dayOfWeek == Calendar.FRIDAY) {
            futureDate= "Fri-" + year;
        } else if (dayOfWeek == Calendar.SATURDAY) {
            futureDate="Sat-" + year;
        } else if (dayOfWeek == Calendar.SUNDAY) {
            futureDate="Sun-" + year;
        }
        return futureDate;
    }

    public static int getWeekday(String date) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date parsedDate = dateFormat.parse(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(parsedDate);

        return calendar.get(Calendar.DAY_OF_WEEK);
    }

    private static boolean isLeapYear(int year) {
        // Leap year logic
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        try {
            String dateOfBirth = "29-02";
            String futureDates = calculateFutureDates(dateOfBirth);
            System.out.println("Future dates: " + futureDates);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}