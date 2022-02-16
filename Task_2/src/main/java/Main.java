import java.math.BigInteger;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    private static final char[] separators = {',','.',';',':'};
    private static String regex;

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter the number to perform the operation");
            BigInteger result = mathOperationOnString(scanner.nextLine());

            System.out.println("Result: "+result);
        }
        catch (NumberFormatException exception) {
            System.out.println("Incorrect input numbers");
            exception.printStackTrace();
        }
        catch (RuntimeException exception) {
            System.out.println(exception.getMessage());
            exception.printStackTrace();
        }
    }
    public static BigInteger mathOperationOnString(String inputString){
        if (inputString.isEmpty()) {
            throw new IllegalArgumentException("Input string cannot be empty");
        }

        regex = createRegex();

        String operation = setTypeOfOperation(inputString);

        String numbersWithSeparators = inputString.substring(0, inputString.length() - 1);
        if (numbersWithSeparators.isEmpty()) {
            throw new RuntimeException("No numbers found.");
        }

        List<Long> numbers = Stream.of(numbersWithSeparators.split(regex))
                .map(numberStr -> Long.parseLong(numberStr))
                .collect(Collectors.toList());

        return performTheOperation(operation, numbers);
    }

    public static String createRegex(){
        return "[" + new String(separators) + "]";
    }

    public static String setTypeOfOperation(String inputString){

        switch (inputString.substring(inputString.length() - 1)) {
            case "+":
                return "+";
            case "-":
                return "-";
            case "*":
                return "*";
            default:
                throw new RuntimeException("There is no operator at the end of the input");
        }
    }

    public static BigInteger performTheOperation(String operation, List<Long> numbers) {

        BigInteger counter = new BigInteger("0");
        switch (operation) {
            case "+":
                for (Long number : numbers) {
                    counter = counter.add(BigInteger.valueOf(number));
                }
                break;
            case "-":
                for (Long number : numbers) {
                    counter = counter.subtract(BigInteger.valueOf(number));
                }
                break;
            case "*":
                counter = new BigInteger("1");
                for (Long number : numbers) {
                    counter = counter.multiply(BigInteger.valueOf(number));
                }
                break;
        }

        return counter;
    }

}
