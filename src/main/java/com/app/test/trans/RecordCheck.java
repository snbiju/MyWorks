package com.app.test.trans;

public class RecordCheck {

    public record UserRecord(String username, String email, int userId) {
    }
    UserRecord userRecord = new UserRecord("rana", "rana@yopmail.com", 1234);


    public static void main(String[] args) {
        RecordCheck check = new RecordCheck();

        System.out.println(check.userRecord.email);
        System.out.println(check.userRecord.toString());
    }
}
