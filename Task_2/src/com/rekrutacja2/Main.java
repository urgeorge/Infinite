package com.rekrutacja2;

import java.math.BigInteger;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    private static final char[] arrayOfSeperators = {',','.',';',':'};
    private static String regex;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the number to perform the operation");
        BigInteger result = mathOperationOnString(scanner.nextLine());

        if(result!=null){
            System.out.println("Result: "+result);
        }
    }
    public static BigInteger mathOperationOnString(String inputString){

        regex = createRegex();

        String operation = setTypeOfOperation(inputString);

        if(operation.equals("error"))
            return null;

        else if(operation.equals("")){
                System.out.println("There is no operation at the end of the string");
                System.out.println("To perform the operation, add the appropriate character to the end of the string");
                System.out.println("Avaiable operations: [+-*]");
                return null;
        }
        else{
            inputString = inputString.substring(0, inputString.length() - 1);
        }

        List<String> listOfStringNumbers = Stream.of(inputString.split(regex))
                .map(elem -> new String(elem))
                .collect(Collectors.toList());

        return performTheOperation(operation, listOfStringNumbers);

    }

    public static String createRegex(){
        String regex = "[";
        for(char separator: arrayOfSeperators){
            regex+=separator;
        }
        regex+="]";
        return regex;
    }

    public static String setTypeOfOperation(String inputString){
        try {
            switch (inputString.substring(inputString.length() - 1)) {
                case "+":
                    return "+";
                case "-":
                    return "-";
                case "*":
                    return "*";
                default:
                    return "";
            }
        }

        catch(StringIndexOutOfBoundsException e){
            System.out.println("The input string cannot be empty");
            return "error";
        }

    }

    public static BigInteger performTheOperation(String operation, List<String> listOfStringNumbers){
        BigInteger counter = new BigInteger("0");
        try {
            switch (operation) {
                case "+":
                    for (String stringnumber : listOfStringNumbers) {
                        counter = counter.add(BigInteger.valueOf(Long.parseLong(stringnumber)));
                    }
                    break;
                case "-":
                    for (String stringnumber : listOfStringNumbers) {
                        counter = counter.subtract(BigInteger.valueOf(Long.parseLong(stringnumber)));
                    }
                    break;
                case "*":
                    counter = new BigInteger("1");
                    for (String stringnumber : listOfStringNumbers) {
                        counter = counter.multiply(BigInteger.valueOf(Long.parseLong(stringnumber)));
                    }
                    break;
            }
        }
        catch (NumberFormatException e){
            System.out.println("You cannot do operations if string is not matched by pattern");
            System.out.println("You can only enter numbers and delimiters (the first number can be negative)");
            System.out.println("Delimiters: "+regex);
            System.out.println("Avaiable operations: [+-*]");
            return null;
        }

        return counter;
    }

}
