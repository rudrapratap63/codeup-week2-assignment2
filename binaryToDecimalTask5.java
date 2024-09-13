/*
In this class, we will implement a method to convert a binary to its Decimal Equivalent
using recursion
Program Owner -> Rudra Pratap Singh
Date -> 11/09/2024
 */

import java.util.Scanner;

public class binaryToDecimalTask5 {
    static double decimalNumberAfterDecimal;
    static boolean isNoError;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            System.out.println("Enter a Integer in binary format :");
            String binaryDecimal = input.nextLine();
            String[] binaryArray = binaryDecimal.split("\\.");
            if ((Long.parseLong(binaryArray[0])) < 0) {
                System.out.println("please enter only positive integer");
                input.close();
                return;
            }
            if (binaryArray.length > 2) {
                System.out.println("Please enter correct decimal binary value");
                input.close();
                return;
            }
            binaryToDecimal(Long.parseLong(binaryArray[0]), 0, 0);
            if (binaryArray.length == 2) {
                binaryDecimalToDecimal(Integer.parseInt(binaryArray[1]), 0, -binaryArray[1].toCharArray().length);
            }
            if (isNoError) {
                System.out.println("Decimal number is : " + decimalNumberAfterDecimal);
            }
        } catch (Exception e) {
            System.out.println("invalid input ");
        }
        input.close();
    }

    // store the value of binary to decimal before point in variable
    // Input -> Long, Long, Integer
    // Return type -> void
    public static void binaryToDecimal(long binaryNumber, long decimalNumber, int index) {
        if (binaryNumber > 0) {
            long binarydigit = (binaryNumber % 10);
            if (binarydigit != 0 && binarydigit != 1) {
                System.out.println("Error: Please enter input in binary format");
                return;
            }
            decimalNumber = decimalNumber + binarydigit * (int) (Math.pow(2, index));
            binaryNumber = binaryNumber / 10;
            binaryToDecimal(binaryNumber, decimalNumber, ++index);
        } else {
            decimalNumberAfterDecimal += decimalNumber;
            isNoError = true;
            return;
        }
    }

    // store the value of binary to decimal after point in variable with addition
    // Input -> Long, double, Integer
    // Return type -> void
    public static void binaryDecimalToDecimal(long binaryNumber, double decimalNumber, int index) {
        if (index < 0) {
            double binarydigit = (binaryNumber % 10);
            if (binarydigit != 0 && binarydigit != 1) {
                System.out.println("Error: Please enter input in binary format");
                isNoError = isNoError & false;
                return;
            }
            decimalNumber = decimalNumber + binarydigit * (Math.pow(2, index));
            binaryNumber = binaryNumber / 10;
            binaryDecimalToDecimal(binaryNumber, decimalNumber, ++index);
        } else {
            System.out.println();
            decimalNumberAfterDecimal += decimalNumber;
            return;
        }
    }
}
