import java.util.Scanner;

public class TipCalculator {
    public static void main(String[] args) {
        // initializing variables
        double totalBill = 0.0;

        // gathering basic info
        Scanner scan = new Scanner(System.in); // initializing scanner
        System.out.println("Welcome to the tip calculator!");
        System.out.print("How many people are in your group: ");
        int numPeople = scan.nextInt();
        scan.nextLine();

        System.out.print("What's the tip percentage? (0-100): ");
        int tipPercentage = scan.nextInt();
        scan.nextLine();

        System.out.print("Enter a cost in dollars and cents, e.g. 12.50 (-1 to end): ");
        double foodCost = scan.nextDouble();
        scan.nextLine();

        while (foodCost != -1) {
            totalBill += foodCost;
            System.out.print("Enter a cost in dollars and cents, e.g. 12.50 (-1 to end): ");
            foodCost = scan.nextDouble();
        }
        scan.close();
    }
}
