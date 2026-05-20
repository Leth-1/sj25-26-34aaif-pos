package at.spengergasse;

import java.time.Year;

public class Mitarbeiter {
    private String name;
    private Year gebJahr;
    private Year eintrJahr;


    public Mitarbeiter(String name, Year gebJahr, Year eintrJahr) {
        setName(name);
        setEintrJahr(eintrJahr);
        setGebJahr(gebJahr);
    }

    public String getName() {
        return name;
    }

    public Year getEintrJahr() {
        return eintrJahr;
    }

    public Year getGebJahr() {
        return gebJahr;
    }

    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Fehler: NULL");
        }
        if (name.isEmpty() || name.isBlank()) {
            throw new IllegalArgumentException("Fehler: Blank");
        }
        this.name = name;
    }

    public void setEintrJahr(Year eintrJahr) {
        if (eintrJahr == null) {
            throw new IllegalArgumentException("Fehler: NULL");
        }
        if (eintrJahr.isAfter(Year.now())) {
            throw new IllegalArgumentException("Fehler: Zukunft");
        }
        this.eintrJahr = eintrJahr;
    }

    public void setGebJahr(Year gebJahr) {
        if (eintrJahr == null) {
            throw new IllegalArgumentException("Fehler: NULL");
        }
        if (eintrJahr.isAfter(Year.now())) {
            throw new IllegalArgumentException("Fehler: Zukunft");
        }
        this.gebJahr = gebJahr;
    }

    public int berechneAlter() {
        return Year.now().getValue() - gebJahr.getValue();
    }

    public int berechneDienstalter() {
        return Year.now().getValue() - eintrJahr.getValue();
    }

    public double berechneGehalt() {
        return 1500 + berechneDienstalter() * 50;
    }

    @Override
    public String toString() {
        return "Mitarbeiter: " +
                "name='" + name + '\'' +
                ", gebJahr=" + gebJahr +
                ", eintrJahr=" + eintrJahr +
                ", Dienstalter" + berechneDienstalter() +
                ", Gehalt: " + berechneGehalt();

    }

    public void print() {
        System.out.println(this);
    }
}
