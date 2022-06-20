import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        convertDecimalToHexa();
        convertBinaryToOctal();
        convertOctalToDecimal();
        convertDecimalToBinary();
        convertHexaToDecimal();
    }

    private static void convertDecimalToHexa()
    {
        int decimalNumber = Integer.parseInt(getNumber());
        System.out.printf("""
                        The number provided was: %s\s
                         The Hexadecimal of the number is: %s\s
                         Using the built-in Java function: %s \n""",
                decimalNumber,
                convertToHexadecimal(decimalNumber),
                convertToHexadecimalWithBuiltinFunction(decimalNumber));
    }

    private static void convertBinaryToOctal()
    {
        String binaryNumber = getNumber();
        int decimalNumber = convertBinaryToDecimal(binaryNumber);
        System.out.printf("""
                        The binary number is: %s\s
                        The decimal number is: %s\s
                        The octal number is: %s \n""",
                binaryNumber,
                decimalNumber,
                convertDecimalToOctal(decimalNumber));
    }

    private static void convertOctalToDecimal()
    {
        String number = getNumber();
        System.out.printf("""
                        The octal number is: %s\s
                        The decimal number is: %s\s
                        The decimal number using the built-in function is: %s \n""",
                number,
                convertOctalToDecimal(number),
                convertOctalToDecimalWithBuiltinFunction(number));
    }

    private static void convertDecimalToBinary()
    {
        System.out.printf("%s \n",convertToBinary(Integer.parseInt(getNumber())));
    }

    private static void convertHexaToDecimal()
    {
        String hexNumber = getNumber();
        System.out.printf("The number was: %s \n" +
                        "The decimal number is: %s \n",
                hexNumber,
                convertHexaToDecimal(hexNumber));
    }

    private static String getNumber()
    {
        System.out.println("Enter a number: ");
        Scanner sc = new Scanner(System.in);
        return sc.next();
    }

    private static String convertToHexadecimalWithBuiltinFunction(int number)
    {
        return Integer.toString(number, 16);
    }

    private static String convertToHexadecimal(int number)
    {
        List<String> hexadecimalNumber = new ArrayList<>();
        StringBuilder hexadecimalString = new StringBuilder();

        while (number / 16 != 0)
        {
            int remainder = number % 16;
            hexadecimalNumber.add(Integer.toString(remainder));
            number = number / 16;
        }

        hexadecimalNumber.add(Integer.toString(number));
        Collections.reverse(hexadecimalNumber);

        for(int i = 0; i < hexadecimalNumber.size(); i++)
        {
            switch (hexadecimalNumber.get(i))
            {
                case "10" -> hexadecimalNumber.set(hexadecimalNumber.indexOf(hexadecimalNumber.get(i)), "A");
                case "11" -> hexadecimalNumber.set(hexadecimalNumber.indexOf(hexadecimalNumber.get(i)), "B");
                case "12" -> hexadecimalNumber.set(hexadecimalNumber.indexOf(hexadecimalNumber.get(i)), "C");
                case "13" -> hexadecimalNumber.set(hexadecimalNumber.indexOf(hexadecimalNumber.get(i)), "D");
                case "14" -> hexadecimalNumber.set(hexadecimalNumber.indexOf(hexadecimalNumber.get(i)), "E");
                case "15" -> hexadecimalNumber.set(hexadecimalNumber.indexOf(hexadecimalNumber.get(i)), "F");
            }
        }
        for (String hexNumber : hexadecimalNumber)
        {
            hexadecimalString.append(hexNumber);
        }
        return hexadecimalString.toString();

    }

    private static int convertBinaryToDecimal(String binaryNumber)
    {
        int decimalNumber = 0;
        int powerBase = 1;
        for (int i = binaryNumber.length() -1; i >= 0; i--)
        {
            decimalNumber += (binaryNumber.charAt(i) - 48)* powerBase;
            powerBase = powerBase * 2;
        }
        return decimalNumber;
    }

    private static String convertDecimalToOctal(int number)
    {
        List<String> octalNumberList = new ArrayList<>();
        StringBuilder octalNumberString = new StringBuilder();
        while (number / 8 != 0)
        {
            octalNumberList.add(String.valueOf(number % 8));
            number = number / 8;
        }
        octalNumberList.add(String.valueOf(number));
        Collections.reverse(octalNumberList);
        for (String octalNumber : octalNumberList)
        {
            octalNumberString.append(octalNumber);
        }
        return octalNumberString.toString();
    }

    private static int convertOctalToDecimalWithBuiltinFunction(String number)
    {
        return Integer.parseInt(number, 8);
    }

    private static int convertOctalToDecimal(String number)
    {
        int decimalNumber = 0;
        double powerBase = 1;

        for (int i = number.length() - 1; i >= 0; i--)
        {
            decimalNumber += (number.charAt(i) - 48) * powerBase;
            powerBase = powerBase * 8;
        }
        return decimalNumber;
    }

    private static String convertToBinary(int number)
    {
        List<Integer> binaryNumberList = new ArrayList<>();
        StringBuilder binaryNumber = new StringBuilder();
        while (number / 2 != 0)
        {
            binaryNumberList.add(number % 2);
            number = number / 2;
        }
        binaryNumberList.add(number);
        Collections.reverse(binaryNumberList);
        for (Integer n : binaryNumberList)
        {
            binaryNumber.append(n);
        }
        return binaryNumber.toString();
    }

    private static int convertHexaToDecimal(String hexNumber)
    {
        int decimalNumber = 0;
        int power = 1;
        for(int i = hexNumber.length() -1; i >= 0; i--)
        {
            if (hexNumber.charAt(i) <= '9')
            {
                decimalNumber += (hexNumber.charAt(i) - 48)  * power;
            }
            else
            {
                decimalNumber += (hexNumber.charAt(i) - 55) * power;
            }
            power = power * 16;
        }
        return decimalNumber;
    }
}
