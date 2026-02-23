package at.spengergasse;

import java.time.Year;

public class Freelancer extends Mitarbeiter{
   private double stundenSatz;
    private int stunden;

    public Freelancer(String name, Year gebJahr, Year eintrJahr, double stundenSatz, int stunden) {
        super(name, gebJahr, eintrJahr);
        setStundenSatz(stundenSatz);
        setStunden(stunden);
    }

    public Freelancer() {
        super("Anna", Year.of(2001), Year.now() );
        setStundenSatz(100.0);
        setStunden(10);
    }

    public double getStundenSatz() {
        return stundenSatz;
    }

    public void setStundenSatz(double stundenSatz) {
       if (stundenSatz <= 0.0){
           throw new IllegalArgumentException("Fehler: zu billig!");
       }
        this.stundenSatz = stundenSatz;
    }

    public int getStunden() {
        return stunden;
    }

    public void setStunden(int stunden) {
        if (stunden <= 0 ){
            throw new IllegalArgumentException("Fehler: Darfst net weniger als 0 std arbeiten!");
        }
        this.stunden = stunden;
    }

    @Override
    public double berechneGehalt() {
        return stundenSatz * stunden;
    }

    @Override
    public String toString() {
        return "Freelancer: " + super.toString() +
                ",stundenSatz: " + stundenSatz +
                ", stunden: " + stunden;

    }
}

// PLF
// ArrayList oder Linklist --> adden removen sotieren (NOCHH)
// Kind class implementieren
