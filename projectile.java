/* Chirayu Patel
    100943140*/

import java.util.Scanner;

public class projectile {

    public static void main(String[] args) {
        // Constant for gravity, scaled by 1000 to use integer arithmetic
        final int GRAVITY = -9810;

        // Create a scanner object for reading user input
        Scanner scanner = new Scanner(System.in);

        // Variables to store user input values
        int angle = 0;
        int velocity = 0;
        int time = 0;

        // Prompt user for the initial angle and validate the input
        while (true) {
            System.out.print("Enter the initial angle (in degrees): ");
            if (scanner.hasNextInt()) {
                angle = scanner.nextInt();
                if (angle > 0) break;  // Valid input received, exit loop
            }
            scanner.nextLine(); // Clear invalid input
            System.out.println("Please enter a positive number for the angle.");
        }

        // Prompt user for the initial velocity and validate the input
        while (true) {
            System.out.print("Enter the initial velocity (in m/s): ");
            if (scanner.hasNextInt()) {
                velocity = scanner.nextInt();
                if (velocity > 0) break;  // Valid input received, exit loop
            }
            scanner.nextLine(); // Clear invalid input
            System.out.println("Please enter a positive number for the velocity.");
        }

        // Prompt user for the time and validate the input
        while (true) {
            System.out.print("Enter the time (in seconds): ");
            if (scanner.hasNextInt()) {
                time = scanner.nextInt();
                if (time > 0) break;  // Valid input received, exit loop
            }
            scanner.nextLine(); // Clear invalid input
            System.out.println("Please enter a positive number for the time.");
        }

        // Convert angle to radians and scale by 1000 for integer arithmetic
        double angleRadians = Math.toRadians(angle);
        int angleRadiansScaled = (int) (angleRadians * 1000);

        // Calculate horizontal distance, scaled by 1000
        int d_x = (int) ((velocity * Math.cos(angleRadiansScaled / 1000.0)) * time * 1000);

        // Calculate vertical distance, scaled by 1000
        int d_y = (int) ((velocity * Math.sin(angleRadiansScaled / 1000.0)) * time * 1000 + 0.5 * GRAVITY * time * time / 1000);

        // Convert results back to normal scale by dividing by 1000
        d_x = d_x / 1000;
        d_y = d_y / 1000;

        // Display the calculated distances
        System.out.println("At time " + time + " seconds:");
        System.out.println("Horizontal distance (d_x): " + d_x + " meters");
        System.out.println("Vertical distance (d_y): " + d_y + " meters");

        // Close the scanner
        scanner.close();
    }
}
