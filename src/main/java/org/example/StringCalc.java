package org.example;

import java.util.ArrayList;

public class StringCalc {

    public static int add(String inputString){
        if (inputString.length()==0)return 0;
        ArrayList<Integer> negativNumbersList= new ArrayList<>();


        inputString = inputString.replaceAll("//;","");
        inputString = inputString.replaceAll(";",",");

        String[] splitList= inputString.trim().replace("\n",",").split(",");


        int sum = 0;
        for (String numberElement:splitList) {
            int parsedNumberElement = Integer.parseInt(numberElement);
            if (parsedNumberElement<0){
                negativNumbersList.add(parsedNumberElement);
            }
            sum+=parsedNumberElement;


        }




        if (negativNumbersList.size()>0)
            throw new IllegalArgumentException("Negatives not allowed: " + negativNumbersList);



        return sum;
    }




}
