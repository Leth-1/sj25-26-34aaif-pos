package at.spengergasse;

import java.util.ArrayList;
import java.util.List;

public class Gym {
    private double maxPreisEur;
    private int maxAnzahl;
    private List<Maschine> maschinen;

    public Gym(int maxAnzahl, List<Maschine> maschinen, double maxPreisEur) {
        this.maxAnzahl = maxAnzahl;
        maschinen = new ArrayList<>();
        this.maxPreisEur = maxPreisEur;
    }

    public double getMaxPreisEur() {
        return maxPreisEur;
    }

    private void setMaxPreisEur(double maxPreisEur) throws Gymexception {
       if (maxPreisEur < 0 || maxPreisEur > 9000.0){
           throw new Gymexception("Fehler: bus");
       }
        this.maxPreisEur = maxPreisEur;
    }

    public int getMaxAnzahl() {
        return maxAnzahl;
    }

    private void setMaxAnzahl(int maxAnzahl) throws Gymexception {
     if (maxAnzahl < 5 || maxAnzahl > 100){
         throw new Gymexception("Fehler");
     }
        this.maxAnzahl = maxAnzahl;
    }

}
