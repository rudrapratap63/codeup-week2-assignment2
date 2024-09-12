import java.util.Scanner;

public class binaryToDecimalTask5 {
    static long binaryNumber;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            System.out.println("Enter a Integer in binary format :");
            binaryNumber = input.nextLong();
            if (binaryNumber<0) {
                System.out.println("Please enter only positive binary number");
                input.close();
                return;
            }
            binaryToDecimal(binaryNumber, 0, 0);
        } catch (Exception e) {
            System.out.println("invalid input ");
        }

        input.close();
    }

    public static void binaryToDecimal(long binaryNumber, long decimalNumber,int index){
        if (binaryNumber > 0) {
            long binarydigit = (binaryNumber % 10);
            if (binarydigit != 0 && binarydigit != 1 ) {
                System.out.println("Error: Please enter input in binary format");
                return;
            }
            decimalNumber = decimalNumber + binarydigit*(int)(Math.pow(2, index));
            binaryNumber = binaryNumber/10;
            binaryToDecimal(binaryNumber, decimalNumber, ++index);
        }else{
            System.out.println("Decimal Representation of binary number is : \n"+decimalNumber);
            System.out.println();
            return;
        }
    }
}
