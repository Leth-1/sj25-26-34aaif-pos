import java.util.Scanner;
import java.text.NumberFormat;

public class MortageCALC{

    public static void main(String[] args){

        Scanner principal= new Scanner(System.in);
        System.out.print("Principal:  ");
        double value = principal.nextDouble();

        Scanner Interest = new Scanner(System.in);
        System.out.print("Annual Interest Rate: ");
        double pro = Interest.nextDouble();

        Scanner Period = new Scanner(System.in);
        System.out.print("Period in years:");
        double Years = Period.nextDouble();

        double monthly = (pro / 100) / 12;

        double Ymonthly= Years * 12;

        System.out.print("Mortage:");
        double factor = Math.pow(1 + monthly, Ymonthly);
        double r = (monthly * factor);
        double f = factor - 1;
        double Mortage = ( r / f) * value;
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        System.out.println("Mortgage: " + currency.format(Mortage));

    
    


    
    }

}