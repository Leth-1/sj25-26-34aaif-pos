package at.spengergasse;

import java.time.Year;

public class Angestellter extends Mitarbeiter {
    public Angestellter(String name, Year gebJahr, Year eintrJahr) {
        super(name, gebJahr, eintrJahr);
    }

    @Override
    public double berechneGehalt() {
        return 1500.0 + berechneDienstalter() * 50.0;
    }

    @Override
    public String toString() {
        return "Angestellter: " + super.toString();

    }
}
