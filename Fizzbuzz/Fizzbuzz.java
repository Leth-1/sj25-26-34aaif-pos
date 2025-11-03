import java.util.Arrays;
import java.util.Scanner;

public class Fizzbuzz {
    public static void main(String[] args){

        for( int i = 0; i < 100; i++){

            if (i % 5 == 0 && i % 3 == 0){
                System.out.println("fizzbuzz");
            } else if (i % 3 == 0) {
                System.out.println("buzz");
            } else if (i % 5 == 0) {
                System.out.println("fizz");
            } else {
                System.out.println(i);
            }

        }
    }
}