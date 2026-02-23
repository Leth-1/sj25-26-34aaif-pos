package at.spengergasse;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Personalbuero {
    private LinkedList<Mitarbeiter> employees; // <-- Collection.


    public Personalbuero() {
        employees = new LinkedList<>();
    }


    public boolean aufnehmen(Mitarbeiter mitarbeiter) {
        if (mitarbeiter == null ||
                mitarbeiter.berechneAlter() < 15 || employees.contains(mitarbeiter)) {
            return false;
        }
        return employees.add(mitarbeiter);
    }

    public double berechneGehaltsumme() {
        double summe = 0.0;
        for (Mitarbeiter ma : employees) {
            summe += ma.berechneGehalt();
        }
        return summe;
    }

    public double berecheDurchschnitssalter() {
        if (employees.isEmpty()) {
            return -99.0;
        }
        double summe = 0.0;
        for (Mitarbeiter ma : employees) {
            summe += ma.berechneAlter();
        }
        return summe / employees.size();
    }

    public int zaehleMitarbeiter() {
        return employees.size();
    }

    public int kuendigenAlle(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Fehler: null");
        }
        if (employees.isEmpty()) {
            return -99;
        }
        int count = 0;
        Iterator<Mitarbeiter> iterator = employees.iterator(); // als methode von collection
        while (iterator.hasNext()) {
            if (iterator.next().getName().equals(name)) {
                iterator.remove();
                count++;
            }
        }
        return count;
    }

    public double kuendigen(double gehalt) {
        if (gehalt <= 0.0) {
            throw new IllegalArgumentException("Fehler:Darf nicht 0 sein");
        }
        if (employees.isEmpty()) {
            return -99;
        }
        double summe = 0.0;
        Iterator<Mitarbeiter> iterator = employees.iterator();
        Mitarbeiter ma;
        while (iterator.hasNext()) {
            ma = iterator.next();
            if (ma.berechneGehalt() > gehalt) {
                summe += ma.berechneGehalt();
                iterator.remove();
            }
        }

        return summe;
    }


    public int zaehleAlter(int alter) {
        if (alter < 15) {
            throw new IllegalArgumentException("Fehler: Alter muss 15 oder mehr sein!");
        }
        if (employees.isEmpty()){
            return -99;
        }
        int count = 0;
        for (Mitarbeiter ma : employees){
            if (ma.berechneAlter() == alter){
                count++;
            }

        }
        return count;
    }

    

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Personalbüro:\n");
        if (!employees.isEmpty()) {
            for (Mitarbeiter ma : employees) {
                sb.append(ma).append("\n");
            }
        } else {
            sb.append("keine Mitarbeiter vorhanden!");
        }
        return sb.toString();
    }


}
