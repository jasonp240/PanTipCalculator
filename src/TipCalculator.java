import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.List;

public class TipCalculator {
    public static void main(String[] args) {
        // initializing variables
        double totalBill = 0.0;
        double totalTip;
        double totalBillWithTipAndTax;
        double personCost;
        double tipPerPerson;
        double costPerPersonWithTipAndTax;
        double totalTax;
        double taxPerPerson;

        List<String> foodList = new ArrayList<>();
        // gathering basic info
        Scanner scan = new Scanner(System.in); // initializing scanner
        System.out.println("Welcome to the tip calculator!");
        System.out.print("How many people are in your group: ");
        int numPeople = scan.nextInt();
        scan.nextLine();

        System.out.print("Tax Percentage? (Ex. 8.875% = 0.08875): ");
        double taxPercentage = scan.nextDouble();
        scan.nextLine();
        // information for tipping
        System.out.println("-------------------------------");
        System.out.println("|    Service    | Typical Tip |");
        System.out.println("|   Restaurant  |    10-25%   |");
        System.out.println("|   Bartenders  |    15-20%   |");
        System.out.println("|  Room Service |    15-20%   |");
        System.out.println("|     Barber    |    10-20%   |");
        System.out.println("|      Taxi     |    15-20%   |");
        System.out.println("-------------------------------"); // separating sections
        System.out.print("What's the tip percentage? (0-100): ");
        double tipPercentage = scan.nextDouble();
        scan.nextLine();

        System.out.print("Enter a cost in dollars and cents, e.g. 12.50 (-1 to end): ");
        double foodCost = scan.nextDouble();
        scan.nextLine();
        System.out.print("Enter the item: ");
        foodList.add(scan.nextLine());

        // initializing while loop
        while (foodCost != -1) {
            totalBill += foodCost; // adding cost to the bill (won't include -1)
            System.out.print("Enter a cost in dollars and cents, e.g. 12.50 (-1 to end): ");
            foodCost = scan.nextDouble();
            scan.nextLine();
            if (foodCost != -1) {
                System.out.print("Enter the item: ");
                foodList.add(scan.nextLine());
            }
        }
        // asking for post/pre-tax
        System.out.print("Do you want to tip based on pre or post tax? (type PRE or POST): ");
        String prePostTax = scan.nextLine();
        //calculations
        totalTax = Math.round(100 * (totalBill * (taxPercentage))) / 100.0;
        if (Objects.equals(prePostTax, "PRE")) {
            totalTip = Math.round(100 * (totalBill * (.01 * tipPercentage))) / 100.0;
        }
        else {
            double bill = totalBill;
            bill += totalTax;
            totalTip = Math.round(100 * (bill * (.01 * tipPercentage))) / 100.0;
        }
        totalBillWithTipAndTax = Math.round(100 * (totalBill + totalTip + totalTax)) / 100.0;
        personCost = Math.round(100 * (totalBill / numPeople)) / 100.0;
        tipPerPerson = Math.round(100 * (totalTip / numPeople)) / 100.0;
        taxPerPerson = Math.round(100 * (totalTax / numPeople)) / 100.0;
        costPerPersonWithTipAndTax = Math.round(100 * (totalBillWithTipAndTax / numPeople)) / 100.0;
        // printing out info
        System.out.println("-------------------------------"); // separating sections
        System.out.println("Total bill before tip and tax: $" + totalBill);
        System.out.println("Total percentage for tax: " + (100 * taxPercentage) + "%");
        System.out.println("Total tax: $" + totalTax);
        System.out.println("Total percentage for tip: " + tipPercentage + "%");
        System.out.println("Total tip: $" + totalTip);
        System.out.println("Total bill with tip and tax: $" + totalBillWithTipAndTax);
        System.out.println("Per person cost before tip and tax: $" + personCost);
        System.out.println("Tip per person: $" + tipPerPerson);
        System.out.println("Tax per person: $" + taxPerPerson);
        System.out.println("Total cost per person: $" + costPerPersonWithTipAndTax);
        System.out.println("-------------------------------"); // separating sections
        // for each loop to print out each individual food
        for (String x : foodList) {
            System.out.println(x);
        scan.close();
        }
    }
}
