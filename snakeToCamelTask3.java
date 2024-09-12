import java.util.Scanner;
import java.util.regex.Pattern;

public class snakeToCamelTask3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String originalString = input.nextLine();
        String throwAwayChars = "()[]{}=?!.:,-_/$@^&+%*\\\"#~/";
        originalString = originalString.replaceAll("[" + Pattern.quote(throwAwayChars) + "]", " ");
        originalString = originalString.toLowerCase();
        System.out.println("Snake case Conversion is: " + convertToSnakeCase(originalString, "", false)); 
        System.out.println("Camel case Conversion is: " + convertToCamelCase(originalString, false, true, "")); 
        input.close();
    }

    
    private static String convertToCamelCase(String value, boolean makeNextUppercase, boolean isFirstCharacter, String result) {
        if (value.isEmpty()) {
            return result;
        }
        char currentCharacter = value.charAt(0);
        if (Character.isSpaceChar(currentCharacter) || Character.isWhitespace(currentCharacter)) {
            return convertToCamelCase(value.substring(1), true, isFirstCharacter, result);
        } else if (isFirstCharacter) {
            result += currentCharacter;
            return convertToCamelCase(value.substring(1), false, false, result);
        } else if (makeNextUppercase) {
            result += Character.toTitleCase(currentCharacter);
            return convertToCamelCase(value.substring(1), false, false, result);
        } else {
            result += currentCharacter;
            return convertToCamelCase(value.substring(1), false, false, result);
        }
    }
    

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