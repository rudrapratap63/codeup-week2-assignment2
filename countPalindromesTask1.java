/*
In this class, we will implement a method to find number of unique valid Palindrome using recursion
Program Owner -> 11/09/2024
Date -> Rudra Pratap Singh
*/

import java.util.Scanner;
public class countPalindromesTask1 {
    static String[] resultArray;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("enter string :");
        try {
            String originalString = input.nextLine();
            if (originalString == null || originalString.isEmpty()) {
                System.out.println("Error: String can't be empty");
                input.close();
                return;
            }
            String result = generateSubStrings(originalString,"", 0, 1);
            System.out.println(result);
            System.out.println("total palindrome is : "+countPalindrome(resultArray, 0, 0));
        } catch(StackOverflowError e){
            System.err.println("Please enter small string");
        }
        input.close();
    }

    // generate unique substrings(non-repeating)
    // Input -> String, integer
    // Return type -> String
    public static String generateSubStrings(String originalString,String result, int start, int end){
        if (start >= originalString.length() && end > originalString.length()) {
            return result;
        }else{
            String appendStringElement = originalString.substring(start, end);
            if (start >= 0 && end>1) { // more than 1st index
                if (start == originalString.length()-1 && end == originalString.length()) {
                    if (!isFound(resultArray, appendStringElement, 0)) {
                        result += appendStringElement;
                        resultArray = result.split(",");
                    }
                }else{
                    if (!isFound(resultArray, appendStringElement, 0)) {
                        result += appendStringElement+",";
                        resultArray = result.split(",");
                    }
                }
            }else{ // first index
                result += appendStringElement+",";
                resultArray = result.split(",");
                }
            }
            if (end == originalString.length()) {
                return generateSubStrings(originalString, result, start+1, start+2);
            }
            return generateSubStrings(originalString, result, start, ++end);
        }
    
    // check unique string for substring
    // Input -> String , integer
    // Return type -> boolean
    public static boolean isFound(String[] result, String element, int index){
        if (index > result.length-1) {
            return false;
        }else if(result[index].equals(element) ){
            return true;
        }
        return isFound(result, element, ++index);
    }

        // Check the string is palindrome or not 
        // Input -> String, Integer
        // Return type -> Boolean
        public static boolean isPalindrome(String mainString,char[] characterArray,int index, String reverseString) {
            if(index < 0) {
                if(reverseString.equals(mainString)) {
                    return true;
                }
                else {
                    return false;
                }
            }
            else {
                reverseString = reverseString + characterArray[index];
                index--;
                return isPalindrome(mainString, characterArray, index, reverseString);
            }
        }

        // Count No of Unique Palindrome
        // Input -> String , int
        // Return type -> Integer
        public static int countPalindrome(String[] resultArray, int index, int count){
            if (index > resultArray.length - 1) {
                return count;
            }else{
                if (isPalindrome(resultArray[index], resultArray[index].toCharArray(), resultArray[index].toCharArray().length-1, "")) {
                    count++;
                }
                return countPalindrome(resultArray, ++index, count);
            }
        }
}
