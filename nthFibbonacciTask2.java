/*
In this class, we will implement a method to calculate the Nth Fibonacci Sequence using recursion
Program Owner -> Rudra Pratap Singh
Date -> 11/09/2024
 */

import java.util.Scanner;

public class nthFibbonacciTask2 {
    static Long nthFibbonacciNumber ;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("enter the nth index : ");
        try {
            int fibbonciIndex = input.nextInt();
            if (fibbonciIndex<0) {
                System.out.println("Please enter only positive value");
                input.close();
                return;
            }
            nthFibbonacci(fibbonciIndex);
            System.out.println(fibbonciIndex+"th number in fibbonacci series is : "+nthFibbonacciNumber);
        } catch (Exception e) {
            System.out.println("invalid input ");
        }
        input.close();
    }

    // Returns the Nth Fibonacci Number from Fibonacci Sequence
    // Input -> Integer
    // Return type -> Long Integer
    public static Long nthFibbonacci(int index){
        if (index == 0) {
            return (long)(0);
        }else if (index == 1) {
            return (long)(1);
        }else{
            nthFibbonacciNumber = nthFibbonacci(index -1) + nthFibbonacci(index - 2);
            return nthFibbonacciNumber;
        }
    }
}
