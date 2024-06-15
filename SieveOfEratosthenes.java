// Author: Chirayu Patel
// Date: 14-06-2024
//File name: SieveOfEratosthenes
// Description: The program uses the Prime numbers to give all prime numbers as an output up to a limit which is
// provided by the user.

import java.util.Scanner;

public class SieveOfEratosthenes {

    public static void main(String[] args) {
        int upperBound = getUpperBound();
        boolean[] isPrime = sieveOfEratosthenes(upperBound);
        printPrimes(isPrime);
    }


    // Ask the user for an integer between 2 and 1000
    // Continue to ask the user for the value until a valid input is given


    private static int getUpperBound() {
        Scanner scanner = new Scanner(System.in);
        int upperBound = 0;

        while (true) {
            System.out.print("Please enter an integer between 2 and 1000: ");
            if (scanner.hasNextInt()) {
                upperBound = scanner.nextInt();
                if (upperBound >= 2 && upperBound <= 1000) {
                    break;
                } else {
                    System.out.println("Error. Please enter an integer between 2 and 1000.");
                }
            } else {
                System.out.println("The input is Invalid. Please enter an integer between 2 and 1000.");
                scanner.next(); // Clear the invalid input
            }
        }

        return upperBound;
    }


    // Use the Sieve of Eratosthenes algorithm to find all prime numbers up to the provided limit.
    private static boolean[] sieveOfEratosthenes(int limit) {
        boolean[] isPrime = new boolean[limit + 1];

        // start the array to true
        for (int i = 2; i <= limit; i++) {
            isPrime[i] = true;
        }

        // use the Sieve of Eratosthenes
        for (int num = 2; num * num <= limit; num++) {
            if (isPrime[num]) {
                for (int multiple = num * num; multiple <= limit; multiple += num) {
                    isPrime[multiple] = false;
                }
            }
        }

        return isPrime;
    }

    //prints the prime numbers as per the boolean array from the Sieve of Eratosthenes.
    private static void printPrimes(boolean[] isPrime) {
        System.out.println("Prime numbers up to the provided limit are:");
        for (int i = 2; i < isPrime.length; i++) {
            if (isPrime[i]) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}
