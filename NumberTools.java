//Name: Chirayu Patel
//Student id: 100943140
//File name: NumberTools.java
//Date: 21 June 2024

import java.util.Scanner;

public class NumberTools {

    // This method is used to check that number is even
    public static boolean isEven(int value) {
        return value % 2 == 0;
    }

    // this method is used to check that number is positive
    public static boolean isPositive(int value) {
        return value > 0;
    }

    // this method is used to check that number is in the Fibonacci sequence
    public static boolean isFibonacci(int value) {
        if (value <= 0) return false;
        if (value == 1) return true;

        int a = 1, b = 1;
        while (b < value) {
            int temp = b;
            b += a;
            a = temp;
        }
        return b == value;
    }

    // this method is used to check that number is a power of two
    public static boolean isPowerOfTwo(int value) {
        if (value <= 0) return false;
        return (value & (value - 1)) == 0;
    }

    // this method is used to check that number is prime
    public static boolean isPrime(int value) {
        if (value <= 1) return false;
        for (int i = 2; i <= Math.sqrt(value); i++) {
            if (value % i == 0) return false;
        }
        return true;
    }

    // this method is used to check that number is a square number
    public static boolean isSquare(int value) {
        if (value < 0) return false;
        int sqrt = (int) Math.sqrt(value);
        return sqrt * sqrt == value;
    }

    // this is the main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter any integer of your choice for testing:");
            if (!scanner.hasNextInt()) {
                System.out.println("ERROR. The entered value is not an integer number ");
                break;
            }

            int value = scanner.nextInt();

            System.out.println("Is " + value + " an even number? " + (isEven(value) ? "Yes." : "No."));
            System.out.println("Is " + value + " a positive number? " + (isPositive(value) ? "Yes." : "No."));
            System.out.println("Is " + value + " a Fibonacci number? " + (isFibonacci(value) ? "Yes." : "No."));
            System.out.println("Is " + value + " a power of two? " + (isPowerOfTwo(value) ? "Yes." : "No."));
            System.out.println("Is " + value + " a prime number? " + (isPrime(value) ? "Yes." : "No."));
            System.out.println("Is " + value + " a square number? " + (isSquare(value) ? "Yes." : "No."));
        }

        scanner.close();
    }
}