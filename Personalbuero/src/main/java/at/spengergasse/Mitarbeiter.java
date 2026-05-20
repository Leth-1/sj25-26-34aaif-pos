package at.spengergasse;

import java.time.Year;

public abstract class Mitarbeiter implements Comparable<Mitarbeiter> {
    private String name;
    private Year gebJahr;
    private Year eintrJahr;

    public Mitarbeiter(String name, Year gebJahr, Year eintrJahr) {
        setName(name);
        setGebJahr(gebJahr);
        setEintrJahr(eintrJahr);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Year getGebJahr() {
        return gebJahr;
    }

    public void setGebJahr(Year gebJahr) {
        if (gebJahr == null) {
            throw new IllegalArgumentException("Fehler: null");
        }
        if (gebJahr.isAfter(Year.now())) {
            throw new IllegalArgumentException("Fehler: liegt in der Zukunft");
        }


        this.gebJahr = gebJahr;
    }

    public Year getEintrJahr() {
        return eintrJahr;
    }

    public void setEintrJahr(Year eintrJahr) {
        if (eintrJahr == null) {
            throw new IllegalArgumentException("Fehler: null");
        }
        if (eintrJahr.isAfter(Year.now())) {
            throw new IllegalArgumentException("Fehler: liegt in der Zukunft");
        }
        this.eintrJahr = eintrJahr;
    }

    public int berechneAlter() {
        return Year.now().getValue() - gebJahr.getValue();
    }

    public int berechneDienstalter() {
        return Year.now().getValue() - eintrJahr.getValue();
    }


    public abstract double berechneGehalt();

    public double berechnePraemie() {
        return switch (berechneDienstalter()) {
            case 15 -> berechneGehalt(); //break;
            case 20 -> berechneGehalt() * 2; //break;
            case 25 -> berechneGehalt() * 3; //break;
            case 50 -> berechneGehalt() * 6; //break;
            default -> 0.0; // ist default muss man machen, switch case wird nur bei bestimme case benutzt.
        };
    }

    //public double berechnePraemie() {
    //        switch (berechneDienstalter()) {
    //            case 15:
    //                return berechneGehalt(); //break;
    //            case 20:
    //                return berechneGehalt() * 2; //break;
    //            case 25:
    //                return berechneGehalt() * 3; //break;
    //            case 50:
    //                return berechneGehalt() * 6; //break;
    //            default:
    //                return 0.0; // ist default muss man machen, switch case wird nur bei bestimme case benutzt.
    //        }
    //    } Eines davon zu PLF LERNEN!!!


    @Override
    public int compareTo(Mitarbeiter o) {
        return name.compareTo(o.getName());
//        if (o == null){
//            throw new NullPointerException("Fehler Null");
//        }
//        if (o.getClass() != getClass()){
//            throw new ClassCastException("Fehler falsche Klasse");
//        }
//        if (this.name.equals(name)){
//            return 0;
//        } else {
//
//        }

    }

    @Override
    // Name: Anna, Geb.Jahr: 2001, Alter: 23, Eintr.Jahr: 2024, Dienstalter: 0, Gehalt: 1500.0
    public String toString() {
        return "Name: " + name +
                ", Geb.Jahr: " + gebJahr +
                ", Alter: " + berechneAlter() +
                ", Eintr.Jahr: " + eintrJahr +
                ", Dienstalter: " + berechneDienstalter() +
                ", Gehalt: " + berechneGehalt();
    }

    public void print() {
        System.out.println(this);
    }

    // abstract
    // kein new Mitarbeiter wenn abstract ist.
    // Mitarbeiter kein Objecte mehr
    // entweder Freelancer oder Angestellter
    // weniger code deswegen besser kein copieren
    //
}
