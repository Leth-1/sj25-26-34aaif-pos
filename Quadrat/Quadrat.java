public class Quadrat{
    public static void quadrat(int n){
        for (int zeile= 0; zeile < n; zeile++){
            for (int spalte= 0; spalte < n; spalte++){
                System.out.print("**");
            }
            System.out.println();
        }

    }

}