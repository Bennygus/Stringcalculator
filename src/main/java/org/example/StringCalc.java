package org.example;

public class StringCalc {

    public static int add(String inputString){
        if (inputString.length()==0)return 0;



        inputString = inputString.replaceAll("//;","");
        inputString = inputString.replaceAll(";",",");

        String[] splitList= inputString.trim().replace("\n",",").split(",");


        int sum = 0;
        for (String element:splitList) {
            sum+=Integer.parseInt(element);

        }




        return sum;
    }




}
