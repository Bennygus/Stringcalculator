package org.example;

public class StringCalc {

    public static int add(String a){
        if (a.length()==0)return 0;

        String[] splitList= a.split(",");


        int sum = 0;
        for (String element:splitList) {
             sum+=Integer.parseInt(element);

        }




        return sum;
    }




}
