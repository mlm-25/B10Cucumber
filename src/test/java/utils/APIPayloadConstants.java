package utils;

import org.json.JSONObject;

public class APIPayloadConstants {

    public static String createEmployeePayload(){

        String createEmployeePayload = "{\n" +
                "  \"emp_firstname\": \"first\",\n" +
                "  \"emp_lastname\": \"last\",\n" +
                "  \"emp_middle_name\": \"middle\",\n" +
                "  \"emp_gender\": \"M\",\n" +
                "  \"emp_birthday\": \"1999-01-12\",\n" +
                "  \"emp_status\": \"Employee\",\n" +
                "  \"emp_job_title\": \"API Tester\"\n" +
                "}";

        return createEmployeePayload;
    }

    public static String createEmployeeBody(){

        JSONObject obj = new JSONObject();
        obj.put("emp_firstname", "first");
        obj.put("emp_lastname", "last");
        obj.put("emp_middle_name", "middle");
        obj.put("emp_gender", "M");
        obj.put("emp_birthday", "1999-01-12");
        obj.put("emp_status", "Employee");
        obj.put("emp_job_title", "API Tester");

        return obj.toString();
    }

    public static String payloadMoreDynamic(String firstname, String lastname, String middleName,
                                            String gender, String empBirthday, String empStatus, String empJobTitle){

        JSONObject obj = new JSONObject();
        obj.put("emp_firstname", firstname);
        obj.put("emp_lastname", lastname);
        obj.put("emp_middle_name", middleName);
        obj.put("emp_gender", gender);
        obj.put("emp_birthday", empBirthday);
        obj.put("emp_status", empStatus);
        obj.put("emp_job_title", empJobTitle);

        return obj.toString();
    }
}
