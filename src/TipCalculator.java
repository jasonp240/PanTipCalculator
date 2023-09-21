import java.util.Scanner;

public class TipCalculator {
    public static void main(String[] args) {
        // initializing variables
        double totalBill = 0.0;
        double totalTip;
        double totalBillWithTip;
        double personCost;
        double tipPerPerson;
        double costPerPersonWithTip;


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

        // initializing while loop
        while (foodCost != -1) {
            totalBill += foodCost; // adding cost to the bill (won't include -1)
            System.out.print("Enter a cost in dollars and cents, e.g. 12.50 (-1 to end): ");
            foodCost = scan.nextDouble();
            scan.nextLine();
        }

        System.out.println("-------------------------------");

        //calculations
        totalTip = Math.round(100 * (totalBill * (.01 * tipPercentage))) / 100.0;
        totalBillWithTip = Math.round(100 * (totalBill + totalTip)) / 100.0;
        personCost = Math.round(100 * (totalBill / numPeople)) / 100.0;
        tipPerPerson = Math.round(100 * (totalTip / numPeople)) /100.0;
        costPerPersonWithTip = Math.round(100 * (totalBillWithTip / numPeople)) / 100.0;

        // printing out info
        System.out.println("Total bill before tip: $" + totalBill);
        System.out.println("Total percentage: " + tipPercentage + "%");
        System.out.println("Total tip: $" + totalTip);
        System.out.println("Total bill with tip: $" + totalBillWithTip);
        System.out.println("Per person cost before tip: $" + personCost);
        System.out.println("Tip per person: $" + tipPerPerson);
        System.out.print("Total cost per person: $" + costPerPersonWithTip);
        scan.close();
    }
}
