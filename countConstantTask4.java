import java.util.Scanner;

public class countConstantTask4 {
    static boolean[] usedConstants;
    public static void main(String[] args) {
        System.out.println("enter a string : ");
        Scanner input = new Scanner(System.in);
        String originalString = input.nextLine();

        char[] characterArray = new char[originalString.length()];
        usedConstants = new boolean[26];

        characterArray = originalString.toLowerCase().toCharArray();
        countConstant(characterArray,0,0,0);

        input.close();
    }
    public static void countConstant(char[] characterArray, int index, int count, int uniqueCount) {
        if (index >= characterArray.length) {
            System.out.println("Total Constants are : "+count);
            System.out.println("Total unique Constants are : "+uniqueCount);
            return;
        }
        char element = characterArray[index];
        if((element>='a'&&element<='z')&&(!(element=='a'||element=='e'||element=='i'||element=='o'||element=='u'))){
            count++;
            if (usedConstants[(int)(characterArray[index])-97]==false) {
                uniqueCount++;
                usedConstants[(int)(characterArray[index])-97] = true;
            }
            countConstant(characterArray, ++index, count, uniqueCount);
        }else{
            countConstant(characterArray, ++index, count, uniqueCount);
        }
    }
}