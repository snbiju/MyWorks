package com.app.codes.php;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class CodeTranslation {
    public static void main(String[] args) throws ParseException {
        Map<String, String> data = new HashMap<>(Arrays.stream(args).collect(Collectors.toMap(
                arg -> arg.split("=")[0],
                arg -> arg.split("=")[1]
        )));
        String macProvided = data.get("mac");
        data.remove("mac");

        String[] version = System.getProperty("java.version").split("\\.");
        int major = Integer.parseInt(version[0]);
        int minor = Integer.parseInt(version[1]);

        if (major >= 5 && minor >= 4) {
            data = data.entrySet().stream()
                    .sorted(Map.Entry.comparingByKey(String.CASE_INSENSITIVE_ORDER))
                    .collect(Collectors.toMap(
                            Map.Entry::getKey,
                            Map.Entry::getValue,
                            (oldValue, newValue) -> oldValue,
                            LinkedHashMap::new
                    ));
        } else {
            data = data.entrySet().stream()
                    .sorted((e1, e2) -> e1.getKey().compareToIgnoreCase(e2.getKey()))
                    .collect(Collectors.toMap(
                            Map.Entry::getKey,
                            Map.Entry::getValue,
                            (oldValue, newValue) -> oldValue,
                            LinkedHashMap::new
                    ));
        }

        String macCalculated = calculateHMAC(data, "4f0a1c73e0a245c987a5fcdb2ef4ec3c");
        if (macProvided.equals(macCalculated)) {
            System.out.println("MAC is fine");
            // Do something here
            if ("Credit".equals(data.get("status"))) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");
                String currentTime = timeFormat.format(new Date());
                String currentDate = dateFormat.format(new Date());
                String email = data.get("buyer");

                // Fetch package end date
                String sql2 = "select pckg_end_dte from admn_usr_bsns_pckg_slct where email=?";
                String packageEndDate = fetchSingleValue(sql2, email);

                // Fetch package details
                String sql = "select * from admn_temp_bsns_pckg_chse where email=?";
                Map<String, String> packageDetails = fetchRowAsMap(sql, email);
                String packageId = packageDetails.get("pckg_id");
                String packageAmount = packageDetails.get("pckg_amnt");

                // Calculate new package end date
                String sql1 = "select pckg_amnt from admntr_bsns_pckg where bsns_pckg_id=?";
                String packageBasicPrice = fetchSingleValue(sql1, packageId);
                double prDayAmount = Double.parseDouble(packageBasicPrice) / 30;
                int totalDays = (int) Math.round(Double.parseDouble(packageAmount) / prDayAmount);

                if (currentDate.compareTo(packageEndDate) > 0) {
                    String startDate = currentDate;
                   /* long daysBetween = (new Date(dateFormat.parse(currentDate).getTime()) - new Date(dateFormat.parse(packageEndDate).getTime())) / (1000 * 60 * 60 * 24);
                    int newTotalDays = (int) (daysBetween + totalDays);
                    String newEndDate = dateFormat.format(new Date(dateFormat.parse(startDate).getTime() + newTotalDays * 24 * 60 * 60 * 1000));

                    String sql3 = "update admn_usr_bsns_pckg_slct set pckg_end_dte=? where email=?";
                    executeUpdate(sql3, newEndDate, email);*/

                    String sql8 = "select rcpt_no from admn_usr_pymnt_hstry where rcpt_no!='' order by pymnt_hstry_id DESC limit 0,1";
                    String lastReceiptNo = fetchSingleValue(sql8);
                    int newReceiptNo = Integer.parseInt(lastReceiptNo) + 1;

                    String sql4 = "insert into admn_usr_pymnt_hstry(email,rcpt_no,invce_no,pckg_id,strt_dte,end_dte,pckg_amnt,amnt_add_dte,amnt_add_tme,pymnt_typ) values(?,?,?,?,?,?,?,?,?,?)";
                 //   executeUpdate(sql4, email, String.valueOf(newReceiptNo), "", packageId, startDate, newEndDate, packageAmount, currentDate, currentTime, "Online");
                } else {
                    String startDate = currentDate;
                  //  long daysBetween = (new Date(dateFormat.parse(packageEndDate).getTime()) - new Date(dateFormat.parse(startDate).getTime())) / (1000 * 60 * 60 * 24);
                  //  int newTotalDays = (int) (totalDays + daysBetween);
                  //  String newEndDate = dateFormat.format(new Date(dateFormat.parse(startDate).getTime() + newTotalDays * 24 * 60 * 60 * 1000));

                    String sql5 = "update admn_usr_bsns_pckg_slct set pckg_end_dte=? where email=?";
                 //   executeUpdate(sql5, newEndDate, email);

                    String sql9 = "select rcpt_no from admn_usr_pymnt_hstry where rcpt_no!='' order by pymnt_hstry_id DESC limit 0,1";
                    String lastReceiptNo = fetchSingleValue(sql9);
                    int newReceiptNo = Integer.parseInt(lastReceiptNo) + 1;

                    String sql6 = "insert into admn_usr_pymnt_hstry(email,rcpt_no,invce_no,pckg_id,strt_dte,end_dte,pckg_amnt,amnt_add_dte,amnt_add_tme,pymnt_typ) values(?,?,?,?,?,?,?,?,?,?)";
                  //  executeUpdate(sql6, email, String.valueOf(newReceiptNo), "", packageId, startDate, newEndDate, packageAmount, currentDate, currentTime, "Online");
                }

                String sql7 = "delete from admn_temp_bsns_pckg_chse where email=?";
                executeUpdate(sql7, email);
            } else {
                SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
                SimpleDateFormat dayMonthYearFormat = new SimpleDateFormat("dd-MM-yyyy");
                String currentTime = dateFormat.format(new Date());
                String currentDate = dayMonthYearFormat.format(new Date());
                String email = data.get("buyer");

                String sql7 = "delete from admn_temp_bsns_pckg_chse where email=?";
                executeUpdate(sql7, email);
            }
        } else {
            System.out.println("Invalid MAC passed");
        }
    }

    private static String calculateHMAC(Map<String, String> data, String secret) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA1");
            String dataString = data.values().stream()
                    .collect(Collectors.joining("|"));
            byte[] hmac = md.digest((dataString + secret).getBytes());
            return bytesToHex(hmac);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    private static String fetchSingleValue(String sql, Object... params) {
        // Implement database connection and query execution
        return ""; // Replace with actual value
    }

    private static Map<String, String> fetchRowAsMap(String sql, Object... params) {
        // Implement database connection and query execution
        return new HashMap<>(); // Replace with actual data
    }

    private static int executeUpdate(String sql, Object... params) {
        // Implement database connection and query execution
        return 0; // Replace with actual update count
    }
}

