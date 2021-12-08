package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class StringCalc {
    private static final String DELIMITER_FOR_SQUARE_BRACKETS ="[\\[].*?[]]";

    public static int add(String inputString){
        if (inputString.length()==0)return 0;

       inputString= checkStringForDelimiters(inputString);


        String[] splitNumberList= inputString.trim().replace("\n",",").split(",");


        return checkForValidNumbersInStringAndGetSum(splitNumberList);
    }
    private static String delimiter;

    private static String checkStringForDelimiters(String inputString) {

        if (inputString.startsWith("//")){

            inputString= inputString.replace("//","");

                 if (inputString.contains("[")&&inputString.contains("]")){

                     inputString = getDelimiterFromSquareBracketsAndReplaceDelimiterForComma(inputString);

                     return inputString;
                 }

            delimiter = transferEverythingBeforeNewLineInInputString(inputString);
            inputString= inputString.replace(delimiter,",").replaceFirst(",","");

            return inputString ;
        }


        return inputString;
    }

    private static String getDelimiterFromSquareBracketsAndReplaceDelimiterForComma(String inputString) {
        delimiter = transferEverythingBeforeNewLineInInputString(inputString);
        long delimiterCounter =delimiter.chars().filter(ch -> ch == '['). count();

        for (int i =0;i<delimiterCounter;i++) {
            String insideDelimiter = delimiter.substring(inputString.indexOf("[") + 1, inputString.indexOf("]"));
            delimiter = delimiter.replaceFirst(DELIMITER_FOR_SQUARE_BRACKETS, "");

            inputString = inputString.replace(insideDelimiter, ",").replaceFirst(",", "");
            inputString = inputString.replaceFirst("\\[", "");
            inputString = inputString.replaceFirst("]", "");
        }
        return inputString;
    }

    private static String transferEverythingBeforeNewLineInInputString(String inputString) {
        return inputString.substring(0,inputString.indexOf("\n"));
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

            Integer valueOfNumberElement = getValueOfStringNumbers(negativNumbersList, numberElement);
            if (valueIsOver1000IgnoreIt(valueOfNumberElement)) continue;

            sum +=valueOfNumberElement;
        }
        return sum;
    }

    private static boolean valueIsOver1000IgnoreIt(Integer valueOfNumberElement) {
        return valueOfNumberElement == null;
    }

    private static Integer getValueOfStringNumbers(ArrayList<Integer> negativNumbersList, String numberElement) {
        int valueOfNumberElement = Integer.parseInt(numberElement);

        if (valueOfNumberElement<0){
            negativNumbersList.add(valueOfNumberElement);
        }
        if (valueOfNumberElement>1000){
            return null;
        }
        return valueOfNumberElement;
    }


}
