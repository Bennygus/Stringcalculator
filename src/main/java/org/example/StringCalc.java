package org.example;

public class StringCalc {

    public static int add(String a){
        if (a.length()==0)return 0;

        String[] splitList= a.split(",");

        int s = Integer.parseInt(splitList[0]);
        int p = Integer.parseInt(splitList[1]);




        return s+p;
    }





}
