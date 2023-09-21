import java.util.Scanner;

public class TipCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the tip calculator!");
        System.out.print("How many people are in your group: ");
        int numPeople = scan.nextInt();
        scan.nextLine();
        System.out.print("What's the tip percentage? (0-100): ");
        int tipPercentage = scan.nextInt();
        scan.close();
    }
}
