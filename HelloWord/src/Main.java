import java.security.Principal;
import java.sql.SQLOutput;
import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*for(int i = 0; i < 5; i++)
             System.out.println("Hello World " + i);
        int i = 5;
        while (i > 0){
            System.out.println("Hello world " + i);
            i--;
        }*/

        /*int Principal = 1;
        double annualInterestRate = 0;
        int years = 30;
        int result = 50;
        while (Principal < 1000 || Principal > 1000_000) {
            System.out.println("Principal ($1k - 1M)");
            Principal = new Scanner(System.in).nextInt();
            System.out.println("Enter a number between 1,000 and 1,000,000.");
            if (Principal >= 1000 && Principal <= 1000_000) {
                System.out.println("Annual Interest Rate (0 - 30): ");
                annualInterestRate = new Scanner(System.in).nextDouble();
                if (annualInterestRate <= 0 || annualInterestRate >= 30)
                    System.out.println("Enter a value greater than 0 and less than 30");
                else  {
                    System.out.println("Period (Years)");
                    years = new Scanner(System.in).nextInt();

                    System.out.println("Mortgage" + result );

                }
            }*/
        // Mortgage calculator

        final int monthOfYear = 12;
        final int percent = 100;
        int Principal = 0;
        double annualInterestRate = 0;
        double monthlyInterestRate = 0;
        int years = 0;
        Scanner scanner = new Scanner(System.in);
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        while (true) {
            System.out.println("Principal (1k - 1M): ");
            Principal = scanner.nextInt();
            if (Principal >=1000 && Principal <= 1000_000)
                break;
            else
                System.out.println("Principal should between 1k - 1M");
        }

        while (true) {
            System.out.println("AnnualInterestRate: ");
            annualInterestRate = scanner.nextDouble();
            if (annualInterestRate >0 && annualInterestRate < 30)
                break;
            else
                System.out.println("Annual Interest Rate should between more than 0 and less than 30");
        }

        while(true) {
            System.out.println("Period: ");
            years = scanner.nextInt();
            if(years >=1 && years <=30){
                monthlyInterestRate = (annualInterestRate / monthOfYear) / percent;
                int months = years * monthOfYear;
                double mortgage = (Principal * (Math.pow(1 + monthlyInterestRate, months) * monthlyInterestRate)
                        / ((Math.pow(1 + monthlyInterestRate, months) - 1)));
                String result = currency.format(mortgage);
                System.out.println(result);
                break;
            }
            System.out.println("Period should between 1 - 30");

        }

    }
}
