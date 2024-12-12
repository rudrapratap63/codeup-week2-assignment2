/*
In this class, we will implement a method to convert a string to camel case and string to snake case using recursion
Program Owner -> Rudra Pratap Singh
Date -> 11/09/2024
 */

import java.util.Scanner;
import java.util.regex.Pattern;

public class snakeToCamelTask3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String originalString = input.nextLine();
        String removingCharacters = "()[]{}=?!.:,-_/$@^&+%*\\\"#~/";
        originalString = originalString.replaceAll("[" + Pattern.quote(removingCharacters) + "]", " ");
        originalString = originalString.toLowerCase();
        System.out.println("Snake case Conversion is: " + convertToSnakeCase(originalString, "", false)); 
        System.out.println("Camel case Conversion is: " + convertToCamelCase(originalString, false, true, "")); 
        input.close();
    }
    
    // Convert the String to its Camel Case Equivalent
    // Input -> String , boolean
    // Return type -> String
    private static String convertToCamelCase(String originalString, boolean makeNextUppercase, boolean isFirstCharacter, String result) {
        if (originalString.isEmpty()) {
            return result;
        }
        char currentCharacter = originalString.charAt(0);
        if (Character.isSpaceChar(currentCharacter) || Character.isWhitespace(currentCharacter)) {
            return convertToCamelCase(originalString.substring(1), true, isFirstCharacter, result);
        } else if (isFirstCharacter) {
            result += currentCharacter;
            return convertToCamelCase(originalString.substring(1), false, false, result);
        } else if (makeNextUppercase) {
            result += Character.toTitleCase(currentCharacter);
            return convertToCamelCase(originalString.substring(1), false, false, result);
        } else {
            result += currentCharacter;
            return convertToCamelCase(originalString.substring(1), false, false, result);
        }
    }
    
    // Convert the String to its Snake Case Equivalent
    // Input -> String , boolean
    // Return type -> String
    public static String convertToSnakeCase(String originalString, String result, boolean appendUnderscore) {
        if (originalString.isEmpty()) {
            return result;
        }
        char currentCharacter = originalString.charAt(0);
        if (Character.isSpaceChar(currentCharacter) || Character.isWhitespace(currentCharacter)) {
            if (appendUnderscore) {
                result += "_";
            }
            return convertToSnakeCase(originalString.substring(1), result, false);
        } else {
            result += currentCharacter;
            return convertToSnakeCase(originalString.substring(1), result, true);
        }
    }
}