package com.app.test.hackerrank;

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
"Sun-2016 Fri-2020 Sat-2021 Sun-2022 Fri-2026 Sat-2027 Sat-2032 Sun-2033 Fri-2037 Sat-2038 Sun-2039 Fri-2043 Sun-2044 Fri-2048 Sat-2049 Sun-2050 Fri-2054 Sat-2055 Sat-2060 Sun-2061 Fri-2065"

 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class BirthdayWeekend {

    public static String calculateFutureDates(String dateOfBirth) throws ParseException {
        StringBuilder result = new StringBuilder();

        String[] arr = dateOfBirth.split("-");
        String date = arr[0];
        String month = arr[1];
        String totalDate;

        for (int year = 2016; year <= 2066; year++) {
            totalDate = year + "-" + month + "-" + date;
            int dayOfWeek = getWeekday(totalDate);

            if (dayOfWeek == Calendar.FRIDAY) {
                result.append("Fri-" + year).append(" ");
            } else if (dayOfWeek == Calendar.SATURDAY) {
                result.append("Sat-" + year).append(" ");
            } else if (dayOfWeek == Calendar.SUNDAY) {
                result.append("Sun-" + year).append(" ");
            }
        }

        return result.toString();
    }

    public static int getWeekday(String date) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date parsedDate = dateFormat.parse(date);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(parsedDate);

        return calendar.get(Calendar.DAY_OF_WEEK);
    }

    public static String calculateFutureWeekendDates(String dateOfBirth) {
        StringBuilder result = new StringBuilder();

        // Parse the input date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate birthday = LocalDate.parse(dateOfBirth + "-2022", formatter); // Using a leap year to avoid issues

        // Calculate future dates for 50 years, considering only weekends
        while (result.toString().split(" ").length < 50) {
            DayOfWeek dayOfWeek = birthday.getDayOfWeek();

            // Check if the day is a weekend (Friday, Saturday, or Sunday)
            if (dayOfWeek == DayOfWeek.FRIDAY || dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY) {
                result.append(dayOfWeek.toString().substring(0, 3)).append("-").append(birthday.getYear()).append(" ");
            }

            // Move to the next Saturday
            birthday = birthday.plusDays(7 - birthday.getDayOfWeek().getValue() + DayOfWeek.SATURDAY.getValue());

            // Check for leap year
            if (!birthday.isLeapYear()) {
                // If not a leap year, move to March 1 to avoid issues
                birthday = birthday.withMonth(3).withDayOfMonth(1);
            }
        }

        return result.toString().trim();
    }


    public static void main(String[] args) throws ParseException {
        // Example usage
        String dateOfBirth = "23-10";
        String futureWeekendDates = calculateFutureDates(dateOfBirth);
        System.out.println("Future weekend dates: " + futureWeekendDates);

        String leapYearBirthDate = "29-02";
        String leapYearWeekendDates = calculateFutureDates(leapYearBirthDate);
        System.out.println("Future weekend dates with leap year: " + leapYearWeekendDates);

    }
}