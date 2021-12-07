package org.example;

import java.util.ArrayList;

public class StringCalc {

    public static int add(String inputString){
        if (inputString.length()==0)return 0;



        inputString = inputString.replaceAll("//;","");
        inputString = inputString.replaceAll(";",",");

        String[] splitNumberList= inputString.trim().replace("\n",",").split(",");


        return checkForValidNumbersInStringAndGetSum(splitNumberList);
    }


    private static int checkForValidNumbersInStringAndGetSum(String[] splitNumberList) {
        int sum = 0;
        ArrayList<Integer> negativNumbersList= new ArrayList<>();

        sum = iterateEveryNumberInStringToGetSum(splitNumberList, sum, negativNumbersList);

        if (negativNumbersList.size()>0)
            throw new IllegalArgumentException("Negatives not allowed: " + negativNumbersList);

        return sum;
    }

    private static int iterateEveryNumberInStringToGetSum(String[] splitNumberList, int sum, ArrayList<Integer> negativNumbersList) {
        for (String numberElement: splitNumberList) {

            int valueOfNumberElement = getValueOfStringNumbers(negativNumbersList, numberElement);


            sum +=valueOfNumberElement;
        }
        return sum;
    }

    private static int getValueOfStringNumbers(ArrayList<Integer> negativNumbersList, String numberElement) {
        int valueOfNumberElement = Integer.parseInt(numberElement);
        if (valueOfNumberElement<0){
            negativNumbersList.add(valueOfNumberElement);
        }
        return valueOfNumberElement;
    }


}
