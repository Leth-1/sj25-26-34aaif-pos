import java.util.Scanner;

public class Quadrat{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Quadrat größe");
    int größe = input.nextInt();
    
        for (int i= 0; i < größe; i++){
            for ( int j= 0; j < größe; j++){
                System.out.print("# ");
            }
            System.out.println();
        }
}
}