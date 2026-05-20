package at.Spengergasse;


public class Main {
    public static void main(String[] args) {
        try {
            Etappe etappe = new Etappe(155, "Bad Aussee");
            System.out.println(etappe);
        } catch(IllegalArgumentException ex){
                System.out.println("Unerwartete Exception:" + ex.getMessage());
            }

        }
    }
