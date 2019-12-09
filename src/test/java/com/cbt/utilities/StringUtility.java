package com.cbt.utilities;

public class StringUtility {

    public static void verifyEqual(String expected, String actual){
        if(expected.equals(actual)){
            System.out.println("Pass");
        }else{
            System.out.println("fail");
        }

    }


    public static void verifyContains(String something, String otherThing){

        boolean result = something.toLowerCase().contains(otherThing.toLowerCase())? true : false;
        System.out.println(result);
    }
}
