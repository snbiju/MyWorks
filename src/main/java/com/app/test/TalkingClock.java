package com.app.test;

import javax.xml.crypto.Data;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TalkingClock {
    public static void main(String[] args) {
        // Get the current time  int year, int month, int date, int hrs, int min, int sec
      //  Date currentTime = new Date(2023, 10, 16, 9, 54, 30);
         Date currentTime = new Date();
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        String formattedTime = dateFormat.format(currentTime);

        // Split the time into hours and minutes
        String[] timeParts = formattedTime.split(":");
        int hours = Integer.parseInt(timeParts[0]);

        int minutes = Integer.parseInt(timeParts[1]);

        // Convert time to words
        //String timeInWords = getTimeInWords(hours, minutes);
        System.out.println(getTimeName(hours, minutes));

        System.out.println("Hours:"+hours+"  Minutes: "+minutes);
        System.out.println( getTime(hours,minutes));

        // Print the result
        // System.out.println(timeInWords);
    }

    public static String getTimeInWords(int hours, int minutes) {
        if (hours > 12) hours = hours % 12;
        String[] hourWords = {
                "midnight", "one", "two", "three", "four", "five", "six",
                "seven", "eight", "nine", "ten", "eleven", "twelve"
        };

        String[] minuteWords = {
                "o'clock", "one", "two", "three", "four", "five", "six", "seven",
                "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen",
                "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty"
        };

        StringBuilder result = new StringBuilder("It's ");

        if (minutes == 0) {
            result.append(hourWords[hours]).append(" o'clock");
        } else if (minutes == 15) {
            result.append("quarter past ").append(hourWords[hours]);
        } else if (minutes == 30) {
            result.append("half past ").append(hourWords[hours]);
        } else if (minutes == 45) {
            result.append("quarter to ").append(hourWords[(hours + 1) % 12]);
        } else if (minutes <= 20) {
            result.append(minuteWords[minutes]).append(" minutes past ").append(hourWords[hours]);
        } else {
            int tens = minutes / 10;
            int ones = minutes % 10;
            result.append(minuteWords[18 + tens]).append(" ").append(minuteWords[ones]).append(" minutes past ").append(hourWords[hours]);
        }

        return result.toString();
    }

    public static String getTimeName(int hours, int minutes) {
        String time_name = "";

        if ((hours >= 1 && hours <= 12) && (minutes >= 0 && minutes <= 59)) {

            String[] hour_mint = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
                    "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen",
                    "Twenty", "Twenty one", "Twenty two", "Twenty three", "Twenty four", "Twenty five",
                    "Twenty six", "Twenty seven", "Twenty eight", "Twenty nine"};

            String nextHourName;
            if (hours == 12)
                nextHourName = hour_mint[1]; // "One" if the hour is 12
            else
                nextHourName = hour_mint[hours + 1]; // The name of the next hour

            System.out.print("Time is: " + hours + ":" + minutes + ".");

            if (minutes == 0)
                time_name = hour_mint[hours] + " o'clock";
            else if (minutes == 15)
                time_name = "Quarter past " + hour_mint[hours];
            else if (minutes == 30)
                time_name = "Half past " + hour_mint[hours];
            else if (minutes == 45)
                time_name = "Quarter to " + nextHourName;
            else if (minutes < 30) // For minutes between 1-29
                time_name = hour_mint[minutes] + " minutes past " + hour_mint[hours];
            else // Between 31-59
                time_name = hour_mint[60 - minutes] + " minutes to " + nextHourName;

        } else
            time_name = "Invalid time format";

        return time_name;
    }

    public static String getTime(int hh, int mm) {

        String[] lowDigits = { "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
                "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen" };
        String[] tens = { "", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety" };
        // 678
        String output = "";
        if (mm == 15 || mm == 30 || mm == 45 || mm == 00) {
            switch (mm) {
                case 15:
                    output += "quarter past " + lowDigits[hh];
                    break;
                case 30:
                    output += "half past " + lowDigits[hh];
                    break;
                case 45:
                    output += "quarter to " + lowDigits[hh + 1];
                    break;
                case 00:
                    output += lowDigits[hh] += " o' clock";
                    break;
                default:
                    output += "ERROR";
                    break;
            }
        } else if (mm < 20) {
            int rmn = mm % 10;
            if (mm == 1)
                output += lowDigits[mm] + " minute past " + lowDigits[hh];
            else
                output += lowDigits[mm] + " minutes past " + lowDigits[hh];
        } else if (mm < 30 && mm > 20) {
            int div = mm / 10;
            if (div > 0)
                output += tens[div] + " ";
            int rmn = mm % 10;
            output += lowDigits[rmn];
            output += " minutes past " + lowDigits[hh];
        } else if (mm > 30 && mm < 60) {
            mm = 60 - mm;
            if (mm < 20) {
                int rmn = mm % 10;
                output += lowDigits[mm];
                output += " minutes to " + lowDigits[hh + 1];
                return output;
            }
            int div = mm / 10;
            if (div > 0)
                output += tens[div] + " ";
            int rmn = mm % 10;
            output += lowDigits[rmn];
            output += " minutes to " + lowDigits[hh + 1];
        }
        // System.out.println("Ouput is "+output);
        return output;
    }

}



