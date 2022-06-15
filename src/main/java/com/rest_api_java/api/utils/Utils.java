package com.rest_api_java.api.utils;

public class Utils {

    //----------------------------------------------------------------------
    //Class Methods
    //----------------------------------------------------------------------

    public static String cleanString(String str) {

        return str.replaceAll("\"", "");
    }

    //----------------------------------------------------------------------

    public static Integer parseStringToInteger(String str) {

        return Integer.parseInt(cleanString(str));
    }
}
