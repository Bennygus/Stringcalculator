package org.example;

import java.util.ArrayList;

public class StringCalc {
    private static final String REPLACES_ALL_EXCEPT_ANY_POSITIV_AND_NEGATIV_NUMBERS ="[^0-9-]";

    private StringCalc() {
    }

    public static int add(String inputString){
        if (inputString.length()==0)return 0;


        String[] splitNumberList= inputString.replaceAll(REPLACES_ALL_EXCEPT_ANY_POSITIV_AND_NEGATIV_NUMBERS,",").split(",");

        return checkForValidNumbersInString(splitNumberList);
    }

    private static int checkForValidNumbersInString(String[] splitNumberList) {
        int sum = 0;
        ArrayList<Integer> negativNumbersList= new ArrayList<>();

        sum = sumOfNumbersInString(splitNumberList, sum, negativNumbersList);

        if (!negativNumbersList.isEmpty())
            throw new IllegalArgumentException("Negatives not allowed: " + negativNumbersList);

        return sum;
    }

    private static int sumOfNumbersInString(String[] splitNumberList, int sum, ArrayList<Integer> negativNumbersList) {
        for (String numberElement: splitNumberList) {

            Integer valueOfNumberElement = getValueOfStringNumbers(negativNumbersList, numberElement);

            sum +=valueOfNumberElement;
        }
        return sum;
    }



    private static Integer getValueOfStringNumbers(ArrayList<Integer> negativNumbersList, String numberElement) {
        if (numberElement.isEmpty())return 0;

        int valueOfNumberElement = Integer.parseInt(numberElement);

        if (valueOfNumberElement<0){
            negativNumbersList.add(valueOfNumberElement);
        }

        if (valueOfNumberElement>1000){
            return 0;
        }
        return valueOfNumberElement;
    }


}
